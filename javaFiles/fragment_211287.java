new Thread() {
    @Override
    public void run() {
        while (keepPrinting) {
            printFiles(inputPath, printer);
        }
    }               
}.start();