internal class EvaluateExpressionVisitor : AstVisitor<double>
{
    public override double Visit(AdditionNode node)
    {
        return Visit(node.Left) + Visit(node.Right);
    }

    public override double Visit(SubtractionNode node)
    {
        return Visit(node.Left) - Visit(node.Right);
    }

    public override double Visit(MultiplicationNode node)
    {
        return Visit(node.Left) * Visit(node.Right);
    }

    public override double Visit(DivisionNode node)
    {
        return Visit(node.Left) / Visit(node.Right);
    }

    public override double Visit(NegateNode node)
    {
        return -Visit(node.InnerNode);
    }

    public override double Visit(FunctionNode node)
    {
        return node.Function(Visit(node.Argument));
    }

    public override double Visit(NumberNode node)
    {
        return node.Value;
    }
}