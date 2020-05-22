internal class BuildAstVisitor : MathBaseVisitor<ExpressionNode>
{
    public override ExpressionNode VisitCompileUnit(MathParser.CompileUnitContext context)
    {
        return Visit(context.expr());
    }

    public override ExpressionNode VisitNumberExpr(MathParser.NumberExprContext context)
    {
        return new NumberNode
        {
            Value = double.Parse(context.value.Text, NumberStyles.AllowDecimalPoint | NumberStyles.AllowExponent)
        };
    }

    public override ExpressionNode VisitParensExpr(MathParser.ParensExprContext context)
    {
        return Visit(context.expr());
    }

    public override ExpressionNode VisitInfixExpr(MathParser.InfixExprContext context)
    {
        InfixExpressionNode node;

        switch (context.op.Type)
        {
            case MathLexer.OP_ADD:
                node = new AdditionNode();
                break;

            case MathLexer.OP_SUB:
                node = new SubtractionNode();
                break;

            case MathLexer.OP_MUL:
                node = new MultiplicationNode();
                break;

            case MathLexer.OP_DIV:
                node = new DivisionNode();
                break;

            default:
                throw new NotSupportedException();
        }

        node.Left = Visit(context.left);
        node.Right = Visit(context.right);

        return node;
    }

    public override ExpressionNode VisitUnaryExpr(MathParser.UnaryExprContext context)
    {
        switch (context.op.Type)
        {
            case MathLexer.OP_ADD:
                return Visit(context.expr());

            case MathLexer.OP_SUB:
                return new NegateNode
                {
                    InnerNode = Visit(context.expr())
                };

            default:
                throw new NotSupportedException();
        }
    }

    public override ExpressionNode VisitFuncExpr(MathParser.FuncExprContext context)
    {
        var functionName = context.func.Text;

        var func = typeof(Math)
            .GetMethods(BindingFlags.Public | BindingFlags.Static)
            .Where(m => m.ReturnType == typeof(double))
            .Where(m => m.GetParameters().Select(p => p.ParameterType).SequenceEqual(new[] { typeof(double) }))
            .FirstOrDefault(m => m.Name.Equals(functionName, StringComparison.OrdinalIgnoreCase));

        if (func == null)
            throw new NotSupportedException(string.Format("Function {0} is not supported", functionName));

        return new FunctionNode
        {
            Function = (Func<double, double>)func.CreateDelegate(typeof(Func<double, double>)),
            Argument = Visit(context.expr())
        };
    }
}