main() {
   int noOfRequests = ..;
   final CountDownLatch doneSignal = new  CountDownLatch(noOfRequests);

   // spawn threads or use an executor service to perform the downloads
   for(int i = 0;i<noOfRequests;i++) {
      new Thread(new Runnable() {
         public void run() {
            // perform the download
            doneSignal.countDown();
         }
      }).start();
   }

   doneSignal.await();  // This will block till all threads are done.
}