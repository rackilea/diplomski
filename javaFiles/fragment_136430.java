public class A {

     public static void someMethod(){
         B b = new B();
         b.start();
     }

    public static void main(String[] args)
    {
       someMethod();
    }
}

public class B extends Thread{
    public void run()
    {
      //logic comes here
    }
}