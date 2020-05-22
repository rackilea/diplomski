public class Arithmetics {
    public static void main(String[] args) {
        // x * (3 + y)
        DoubleBinaryOperator func=op(MUL, X, op(ADD, constant(3), Y));
        System.out.println(func.applyAsDouble(5, 4));
        PREDEFINED_UNARY_FUNCTIONS.forEach((name, f) ->
            System.out.println(name+"(0.42) = "+f.applyAsDouble(0.42)));
        PREDEFINED_BINARY_FUNCTIONS.forEach((name, f) ->
            System.out.println(name+"(0.42,0.815) = "+f.applyAsDouble(0.42,0.815)));
        // sin(x)+cos(y)
        func=op(ADD,
            op(PREDEFINED_UNARY_FUNCTIONS.get("sin"), X),
            op(PREDEFINED_UNARY_FUNCTIONS.get("cos"), Y));
        System.out.println("sin(0.6)+cos(y) = "+func.applyAsDouble(0.6, 0.5));
    }
    public static DoubleBinaryOperator ADD = Double::sum;
    public static DoubleBinaryOperator SUB = (a,b) -> a-b;
    public static DoubleBinaryOperator MUL = (a,b) -> a*b;
    public static DoubleBinaryOperator DIV = (a,b) -> a/b;
    public static DoubleBinaryOperator REM = (a,b) -> a%b;

    public static <T> DoubleBinaryOperator op(
        DoubleUnaryOperator op, DoubleBinaryOperator arg1) {
        return (x,y) -> op.applyAsDouble(arg1.applyAsDouble(x,y));
    }
    public static DoubleBinaryOperator op(
        DoubleBinaryOperator op, DoubleBinaryOperator arg1, DoubleBinaryOperator arg2) {
        return (x,y)->op.applyAsDouble(arg1.applyAsDouble(x,y),arg2.applyAsDouble(x,y));
    }
    public static DoubleBinaryOperator X = (x,y) -> x, Y = (x,y) -> y;
    public static DoubleBinaryOperator constant(double value) {
        return (x,y) -> value;
    }

    public static final Map<String,DoubleUnaryOperator> PREDEFINED_UNARY_FUNCTIONS
        = getPredefinedFunctions(DoubleUnaryOperator.class,
            MethodType.methodType(double.class, double.class));
    public static final Map<String,DoubleBinaryOperator> PREDEFINED_BINARY_FUNCTIONS
        = getPredefinedFunctions(DoubleBinaryOperator.class,
            MethodType.methodType(double.class, double.class, double.class));

    private static <T> Map<String,T> getPredefinedFunctions(Class<T> t, MethodType mt) {
        Map<String,T> result=new HashMap<>();
        MethodHandles.Lookup l=MethodHandles.lookup();
        for(Method m:Math.class.getMethods()) try {
            MethodHandle mh=l.unreflect(m);
            if(!mh.type().equals(mt)) continue;
            result.put(m.getName(), t.cast(LambdaMetafactory.metafactory(
            MethodHandles.lookup(), "applyAsDouble", MethodType.methodType(t),
            mt, mh, mt) .getTarget().invoke()));
        }
        catch(RuntimeException|Error ex) { throw ex; }
        catch(Throwable ex) { throw new AssertionError(ex); }
        return Collections.unmodifiableMap(result);
    }
}