public class A{
  public A(String s){
      System.out.println("A");
   }
}

public class B extends A{
    public B(String s){
       super(s);
       System.out.println("B");
   }
}