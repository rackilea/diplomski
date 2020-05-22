class MyType {
   Foo foo;
   Bar bar;

   void doFoo() { foo.do(); }
   void doBar() { bar.do(); }
}

class MyActions {
    MyType thing;

    void lotsOfFoo() {
        // blocks bar :-(
        synchronized(thing) { thing.doFoo(); } 
    }

    void lotsOfBar() {
        // blocks foo :-(
        synchronized(thing) { thing.doBar(); } 
    }

}