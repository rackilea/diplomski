MyGoogleSearch startParsing = new MyGoogleSearch();

Thread t = new Thread(new Runnable(){
    public void run(){
        startParsing.startParser(othoSelection);
    }
}

// don't wait for this thread to finish
t.start();