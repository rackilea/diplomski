public class InstanceofOperator implements BinaryOperator {

    /**
     * This precedence is set based on
     * <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html">Java
     * Operators</a> 30 is the same precedence pebble has set for operators like {@code instanceof}
     * like <a href="https://github.com/PebbleTemplates/pebble/wiki/extending-pebble">Extending
     * Pebble</a>.
     */
    public int getPrecedence() {
        return 30;
    }

    public String getSymbol() {
        return "instanceof";
    }

    public Class<? extends BinaryExpression<?>> getNodeClass() {
        return InstanceofExpression.class;
    }

    public Associativity getAssociativity() {
        return Associativity.LEFT;
    }

}