ReferenceQueue<Foo> fooQueue = new ReferenceQueue<Foo>();

class ReferenceWithCleanup extends WeakReference<Foo> {
  Bar bar;
  ReferenceWithCleanup(Foo foo, Bar bar) {
    super(foo, fooQueue);
    this.bar = bar;
  }
  public void cleanUp() {
    bar.cleanUp();
  }
}

public Thread cleanupThread = new Thread() {
  public void run() {
    while(true) {
      ReferenceWithCleanup ref = (ReferenceWithCleanup)fooQueue.remove();
      ref.cleanUp();
    }
  }
}

public void doStuff() {
  cleanupThread.start();
  Foo foo = new Foo();
  Bar bar = new Bar();
  ReferenceWithCleanup ref = new ReferenceWithCleanup(foo, bar);
  ... // From now on, once you release all non-weak references to foo,
      // then at some indeterminate point in the future, bar.cleanUp() will
      // be run. You can force it by calling ref.enqueue().
}