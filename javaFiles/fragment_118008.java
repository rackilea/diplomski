public class URLProcessingThread implments Runnable {
    CountDownLatch latch;
    URL url;
    public  URLProcessingThread(URL url,  CountDownLatch latch){
       this.latch = latch;
       this.url = url;
    }
    void run() {
         //process url here
         //after everything finishes decrement the latch
         latch.countDown();//reduce count of CountDownLatch by 1

    }
}