class deadlockA implements Runnable
{
  Thread t;
  A a1;
  B b1;
   deadlockA(B b2)
   {
   a1 = new A(); //Create an object
   b1=b2;
   t=new Thread(this);
   t.start();
   }

   public void run()
   {
     a1.funcA(b1);
   }

}


class deadlockB implements Runnable
{
  Thread t;
  A a2;
  B b3;

   deadlockB(A a3)
   {
     b3 = new B(); // Create an object
     a2=a3;
     t=new Thread(this);
     t.start();
   }

   public void run()
   {
     b3.funcB(a2);
   }

}