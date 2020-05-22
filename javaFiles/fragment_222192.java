class A {
   public void foo(List list) { }
}

class B extends A {
   @Override
   public void foo(List<Integer> list) {}
}