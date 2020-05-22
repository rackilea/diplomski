public class A {
     public void someMethod(){
         B b = new B();
         Thread t = new Thread(b);
         t.start()
     }

     public static void main(String[] args)
     {
        someMethod();
     }
}

//Now below class can extend any other class
public class B implements Runnable{
    public void run()
    {
      //logic comes here
    }
}