class Outer {
    class NonStaticInner {}
    static class StaticInner {}
    public List<Object> foo(){ 
        return Arrays.asList(
            new NonStaticInner(),
            new StaticInner()); 
    }
}