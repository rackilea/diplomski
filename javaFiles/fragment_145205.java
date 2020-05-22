public static void main(String args[]){
     Thread nameThread1 = new Thread(new Method1(x));
     nameThread1.start();
     Thread nameThread2 = new Thread(new Method2(x));
     nameThread2.start();
     Thread nameThread3 = new Thread(new Method3(x));
     nameThread3.start();
     Thread nameThread4 = new Thread(new Method4(x));
     nameThread4.start();
     Thread nameThread5 = new Thread(new Method5(x));
     nameThread5.start();
}

public class Method1 implements Runnable {
   private Object obj;
   public Method1(Object obj) {
       this.obj = obj;
   }
   //fileName.java
   public void run(){
      //Do Method Stuff
   }
}