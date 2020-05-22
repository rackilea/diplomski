class Outer {
    Outer(){}
    public List<Object> foo(){ 
        return Arrays.asList(
            new Outer$NonStaticInner(this),
            new StaticInner()); 
    }
}
class Outer$NonStaticInner {
    private final Outer this$0;
    Outer$NonStaticInner(Outer enclosing) { this$0 = enclosing; }
}
class Outer$StaticInner {
    Outer$StaticInner(){}
}