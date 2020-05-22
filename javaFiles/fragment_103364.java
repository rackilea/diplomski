new Thread(new Runnable() {
    public void run() {
        while(true){
            setupThings();
            try {
                Thread.sleep(5000);
            }catch(Exception e){}
        }
    }
}).start();