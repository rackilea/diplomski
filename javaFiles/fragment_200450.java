public static void main(String [] args){

    ExecutorService ex= Executors.newFixedThreadPool(10);

    final Locking producer = new Locking();

    for (int i=0; i<10;i++)
    {
        ex.submit(new Runnable(){

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                producer.producer();
            }

        });
    }

    ex.shutdown();
}