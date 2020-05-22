import java.lang.reflect.*;

class Generic<T> {
}

class IntegerGeneric extends Generic<Integer> {
}

class Main {
    public static void main(String[] args) {

        final Generic<Integer> gint3 = new IntegerGeneric();
        final Generic<Double> gint4 = new Generic<Double>() {};
        System.err.println("gint3's type-parameter: "
            + ((ParameterizedType)gint3.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        System.err.println("gint4's type-parameter: "
            + ((ParameterizedType)gint4.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
// Output:
// gint3's type-parameter: class java.lang.Integer
// gint4's type-parameter: class java.lang.Double