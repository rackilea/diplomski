Thread n = new Thread(new Runnable() {
    public void run() {
        while(true) { //control this with your own boolean, or it will run forever
            try {
                addClient();
            }catch(IOException e) { }
        }
    }
});