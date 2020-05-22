class A implements Bar, Foo{
   private int a;
   ...
}
class B implements Bar, Foo{
   private String b;
   ...
}
class SomeImplementor implements FooBar {
   private A someField;
   public <T extends Foo & Bar> T getFooBar() {
      return someField;
   }
}