class WritableComparator {
    public WritableComparator(){
        System.out.println("default constructor is called");
    }
    public WritableComparator(Class<?> clazz, boolean flag) {
        System.out.println("two arguemnts constructor is called");
    }
}

class KeyComparator extends WritableComparator {
    public KeyComparator() {
        //super(); // by default added by the compiler
        super(IntPair.class, true);
    }
}