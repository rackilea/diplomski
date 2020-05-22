public Item implements Runnable {
    private JProgressBar progressBar;
    public void importItems (JProgressBar progressBar, CountDownLatch latch) throws IOException { //Metodo per importare articoli da un file esterno. Usa i Thread.

        this.progressBar = progressBar;

        Thread importThread = new Thread (new RefreshTable(),"Importer Thread");

        importThread.start();

    }

    void run () {

        // I execute here all the DB operation that i need. I also update the progress bar here
        //After everything finishes:
        latch.countDown(); // you want this to be executed in a finally block of the try catch
    }


}