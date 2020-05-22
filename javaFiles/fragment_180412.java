class Parent {
    protected interface Wrapper extends Library {
        Wrapper INSTANCE = Native.loadLibrary( C_LIBRARY_PATH, Wrapper.class ); 
        double functionA();
        double functionB();
    }
}

class A extends Parent {
    public double callA() {
        return Wrapper.INSTANCE.functionA();
    }
}

class B extends Parent {
    public double callB() {
        return Wrapper.INSTANCE.functionB();
    }
}