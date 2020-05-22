Thread thread = new Thread()
{
    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep(5000); // for the 5 seconds requirement
                results = sendGetMessage();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
};

thread.start();