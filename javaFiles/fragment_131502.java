try {
  ob1.t.join();
  ob2.t.join();
  ob3.t.join();
} catch(InterruptedException e) {
  System.out.println("Interrupted");
}