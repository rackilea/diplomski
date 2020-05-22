class Outer<T>{
        class Inner<S> {
            S s;
        }
    }

Outer.Inner<Double> x = null;  // illegal