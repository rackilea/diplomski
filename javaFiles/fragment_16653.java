public class Mythread implements Runnable{



public synchronized void goo(){

System.out.println("Before Wait");

wait();

System.out.println("After Wait");


}


public synchronized void foo(){

System.out.println("Before Notify");

notify();

System.out.println("After Notify");

}


public class Test{

public static  void main(String[] args){

Thread t = new Thread(new Mythread);

t.start();

 }
}