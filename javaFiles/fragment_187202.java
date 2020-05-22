List<Thread> threadList = new ArrayList<Thread>();
for (int i = 0; i < 10; i++) {
   Thread thread = new Thread(new Runnable(){...});
   thread.start();
   threadList.add(thread);
}
// this waits for all of the threads to finish before continuing
for (Thread thread : threadList) {
   thread.join();
}