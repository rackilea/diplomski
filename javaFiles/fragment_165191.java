@Getter @Setter
public class Expression {
    private int aSpecificKey;
}

@Getter @Setter
public class SimpleExpression extends Expression {
    public SimpleExpression() {
        setASpecificKey(0);
    }
    private String operand;
    private int someComparisonOperator;
    private String[] values; 
}

@Getter @Setter
public class ComplexExpression extends Expression {
    public ComplexExpression() {
        setASpecificKey(1);
    }   
    private String someOperator;
    private Expression[] expressions;
}