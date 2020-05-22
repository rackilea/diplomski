class A {
 void run()
 {
  new B().start();
 }
}

class B extends Thread {
  public void run(){
    C c = new C();  
    c.do something with A .. }
}