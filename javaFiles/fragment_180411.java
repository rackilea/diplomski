class A {
    protected interface Wrapper extends Library {
        Wrapper INSTANCE = Native.loadLibrary( C_LIBRARY_PATH, Wrapper.class ); 
        double functionA();
    }
    public double callA() {
        return Wrapper.INSTANCE.functionA();
    }
}

class B {
    protected interface Wrapper extends Library {
        Wrapper INSTANCE = Native.loadLibrary( C_LIBRARY_PATH, Wrapper.class ); 
        double functionB();
    }
    public double callB() {
        return Wrapper.INSTANCE.functionB();
    }
}