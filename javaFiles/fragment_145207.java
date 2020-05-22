public static void main(String args[]){
     Thread nameThread1 = new Thread(new Method(1, x));
     nameThread1.start();
     Thread nameThread2 = new Thread(new Method(2, x));
     nameThread2.start();
     ...
}
public class Method1 implements Runnable {
   private int which;
   private Object obj;
   public Method1(int which, Object obj) {
       this.which = which;
       this.obj = obj;
   }
   //fileName.java
   public void run(){
       switch(which) {
          case 1:
             doMethod1(obj);
             break;
          case 2:
             doMethod2(obj);
             break;
          ...
       }
    }
    private void doMethod1(Object obj){
       ...
    }
    private void doMethod2(Object obj){
       ...
    }
}