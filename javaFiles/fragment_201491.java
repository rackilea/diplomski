class App {
    private A a;
    public App() { 
      // not necessary to have, just to show that we have no logic inside 
    }
    protected void init() {  // choose access modifiers
        // init something in App;
        a = new A(this);  // safe to pass this now.           
    }
}

class A {
   private final App app;

   public A(App app) {
      this.app = app;
      // do whatever you need
      // if logic affects other components, create init() method here
   }      
}