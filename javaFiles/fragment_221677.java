class Demo<T> {
    public <X> Demo(X[] arg1, X arg2) { 
        // initialization code
        System.out.println(arg1.getClass());
        System.out.println(arg2.getClass());
    }
}