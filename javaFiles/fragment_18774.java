public static void main(String[] args) {
     ExecutorService threadPool = Executors.newCachedThreadPool();
     for (int i = 0; i < 4; i++) {
         threadPool.execute(new Runnable() {
              public void run() {
                  long total = 0;
                  while (true) {
                     total++;
                  }
              }
         });
     }
 }