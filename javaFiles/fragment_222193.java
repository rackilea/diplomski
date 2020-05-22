class A {
   public void foo(List<String> list) { }
}

class B extends A {
   @Override
   public void foo(List<Integer> list) {}
}