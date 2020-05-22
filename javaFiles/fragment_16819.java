internal abstract class ExpressionNode
{
}

internal abstract class InfixExpressionNode : ExpressionNode
{
    public ExpressionNode Left { get; set; }
    public ExpressionNode Right { get; set; }
}

internal class AdditionNode : InfixExpressionNode
{
}

internal class SubtractionNode : InfixExpressionNode
{
}

internal class MultiplicationNode : InfixExpressionNode
{
}

internal class DivisionNode : InfixExpressionNode
{
}

internal class NegateNode : ExpressionNode
{
    public ExpressionNode InnerNode { get; set; }
}

internal class FunctionNode : ExpressionNode
{
    public Func<double, double> Function { get; set; }
    public ExpressionNode Argument { get; set; }
}

internal class NumberNode : ExpressionNode
{
    public double Value { get; set; }
}