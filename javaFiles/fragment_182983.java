public class A {
   public static String foo() {
     return "hello world";
   }
}

public class B extends A {
   public void bar() {
      System.out.println(foo());
   }
}