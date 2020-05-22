java.util.List<Thread> al = new java.util.ArrayList<Thread>();
for (int i=0; i<30; i++){
  Runnable r = new CheckProxy(ip[i], port[i]);
  Thread t = new Thread(r);
  al.add(t);
  t.start();
}
// Ensure all of the threads finish before continuing.
for (Thread t : al) {
  t.join(); // or t.interrupt();
}