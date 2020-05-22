public abstract class GenericMath<T extends Number> {
    public T a,b;

    public abstract T add();
    public abstract T multiply();
}

public class IntegerGenericMath extends GenericMath<Integer> {
    public Integer add() {
        return a + b;
    }
    public Integer multiply() {
        return a * b;
    }
}

// similar for Double

public static void main(String[] args) {

    IntegerGenericMath x=new IntegerGenericMath();
    x.a=5;
    x.b=10;
    int z=x.add();

    DoubleGenericMath y = new DoubleGenericMath();
    y.a = 5.5;
    y.b = 10.2;
    double g=y.multiply();
}