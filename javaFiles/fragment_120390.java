class StaticClass {
    public static void m1 () {
      new Worker().m1();
    }
    public static void m2 () {
      new Worker().m2();
    }
}

class Worker {
   public Worker() {
     intialize();
   }
   public void m1() {
     // Real m1 work
   }
   public void m2() {
     // Real m2 work
   }
}