enum Type {
    Integer,
    Boolean;
}

class ScriptObject {
    private final Object value;
    private final Type type;

    private ScriptObject(Object value, Type type) {
        this.value = value;
        this.type = type;
    }

    public static ScriptObject of(boolean b) {
        return new ScriptObject(b, Type.Boolean);
    }

    public static ScriptObject of(int i) {
        return new ScriptObject(i, Type.Integer);
    }

    public int asInt() {
        return (int) value;
    }

    public boolean asBoolean() {
        return (boolean) value;
    }

    public static boolean areType(Type type, ScriptObject...objects) {
        for(ScriptObject o : objects) {
            if(o.type != type)
                return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}

abstract class Expression {
    public abstract ScriptObject getValue();
}

class BasicExpression extends Expression {
    private final ScriptObject value;

    public BasicExpression(ScriptObject value) {
        this.value = value;
    }

    @Override
    public ScriptObject getValue() {
        return value;
    }

}

abstract class BinaryExpression extends Expression {
    private final Expression left;
    private final Expression right;

    public BinaryExpression (Expression l, Expression r) {
        this.left = l;
        this.right = r;
    }

    @Override
    public ScriptObject getValue() {        
        return operation(left.getValue(), right.getValue());
    }

    protected abstract ScriptObject operation(ScriptObject left, ScriptObject right);

}