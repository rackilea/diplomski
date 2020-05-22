public interface Expression {
    public Value evaluate();
}

public class Value implements Expression {
    private final float floatValue;

    public Value(float floatValue) {
        this.floatValue = floatValue;
    }

    public float floatValue() {
        return floatValue;
    }

    @Override
    public Value evaluate() {
        return this;
    }
}

public abstract class BinaryOperator implements Expression {
    protected final Expression lhs, rhs;

    public BinaryOperator(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
}

public class Add extends BinaryOperator {
    public Add(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    public Value evaluate() {
        return new Value(
            lhs.evaluate().floatValue()
                +
            rhs.evaluate().floatValue()
        );
    }
}

public class Multiply extends BinaryOperator {
    public Multiply(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    public Value evaluate() {
        return new Value(
            lhs.evaluate().floatValue()
                *
            rhs.evaluate().floatValue()
        );
    }
}