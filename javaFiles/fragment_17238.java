class A {
 void run()
 {
  new B(this).start();
 }
}

class B extends Thread {
  public void run(A a){ 
    C c = new C();
    c.do something(a).. 
  }
}