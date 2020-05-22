Thread thread = new Thread()
{
    @Override
    public void run() {
        try {
            while(true) {
                sleep(1000);
                handler.post(r);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
};

thread.start();