Set<Future> futures = new HashSet<>();
for(int n = 0; ...) {
   futures.add(pool.submit(new Runnable() {...}));
}

for(Future f : futures) {
  f.get(); //blocks until the task is completed
}