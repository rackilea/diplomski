while (true) {
   A threadA = new A(mutex);
   B threadB = new B(mutex);
   C threadC = new C(mutex);
   threadA.start();
   threadB.start();
   threadC.start();
   threadA.join();
   threadB.join();
   threadC.join();
}