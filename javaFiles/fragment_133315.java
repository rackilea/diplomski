public class A {
    public static String s = "A";
    //...
}

public class B {
    //...

   public static void vandalizeClassA() {
       System.out.println(A.s); //output will be "A"
       A.s = "B was here"; 
       System.out.println(A.s); //output will be "B was here"
   }
}