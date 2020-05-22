class Bar {
   public void method() throws SomeCheckedException{}
}

class Foo extends Bar {
    @Override  
    public void method() throws SomeOtherUnrelatedCheckedException{}
}