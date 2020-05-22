public abstract class Expressions {
    public static DotExpression dot(NameExpression lhs, Expression rhs);
    public static BooleanExpression where(Expression lhs, Expression rhs);
    public static NameExpression name(String name);
    public static BooleanExpression gt(Expression lhs, Expression rhs);
}