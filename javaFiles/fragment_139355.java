class Base {
    public void foo() {}
    public void bar() {}
}
class Derived extends Base {
    @Override   
    public void bar() {}
}
...
Method mfoo = Derived.class.getMethod("foo");
boolean ovrFoo = mfoo.getDeclaringClass() != Base.class;
Method mbar = Derived.class.getMethod("bar");
boolean ovrBar = mbar.getDeclaringClass() != Base.class;
System.out.println("Have override for foo: "+ovrFoo);
System.out.println("Have override for bar: "+ovrBar);