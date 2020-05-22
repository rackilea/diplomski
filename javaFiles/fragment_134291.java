Thread worker = new Thread(new Runnable(){
    public void run(){
        jTextArea.append("Test" + "\n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        jTextArea.append("Test1" + "\n");

    }
});
worker.start();