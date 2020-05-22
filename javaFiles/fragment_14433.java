public class ObjectA {

  private void foo() {
     MutableObject mo = new MutableObject();
     Runnable objectB = new ObjectB(new AtomicReference<>( mo ) );
     new Thread(objectB).start();
  }
}

public class ObjectB implements Runnable {

  private AtomicReference<MutableObject> mo;

  public ObjectB(AtomicReference<MutableObject> mo) {
    this.mo = mo;
  }

  public void run() {
   //read some field from mo
   mo.get().readSomeField();
  }
}