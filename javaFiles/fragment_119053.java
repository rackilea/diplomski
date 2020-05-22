List<OBJ> objects = new ArrayList<OBJ>();
// Create your objects here
for (int i = 0; i < NUM_OF_OBJ; ++i) {
   objects.add(new OBJ());
}

// Run the threads
List<Thread> threads = new ArrayList<Thread>();
for (int i = 0; i < NUM_OF_OBJ; ++i) {
   Thread t = new Thread(objects.get(i));
   threads.add(t);
   t.start();
}

// Wait for the threads to finish
for (Thread t : threads) {
    t.join();
}

// Sum all counts
int sum = 0;
for (OBJ object : objects) {
   sum += object.getCount();
}