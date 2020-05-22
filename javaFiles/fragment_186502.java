public static void main(String[] args) throws InterruptedException {

    CountDownLatch countLatch = new CountDownLatch(10);
    ExecutorService threadPool = Executors.newFixedThreadPool(10);
    ArrayList<SampleImageDownload> list = new ArrayList<SampleImageDownload>();
    int row =1;

    while (row <=10) {
        int tileno = 1;
        while(tileno <=10) {
         SampleImageDownload sample = new SampleImageDownload(countLatch, tileno);
         list.add(sample);
         threadPool.submit(sample); 
         tileno++;

        } 
            row++;
            countLatch.await(); // wait for all 10 tiles to download.
        //apendline
    }




}


class SampleImageDownload implements Runnable {

    int tileno;
    private CountDownLatch countLatch = null;
    BufferedImage tile = null;


    public SampleImageDownload(CountDownLatch countLatch, int tileno) {
        super();
        this.countLatch = countLatch;
        this.tileno = tileno;
    }


    @Override
    public void run() {

        // download and removeBlacktile
        // tile is ready
        countLatch.countDown();

    }

}