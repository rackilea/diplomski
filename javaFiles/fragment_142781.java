public static final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();

public static void main(String[] args) throws Exception {
    new Thread(new Runnable(){
        @Override
        public void run() {
            final int result;
            result = 2+3;
            queue.add(new Runnable(){
                @Override
                public void run() {
                    System.out.println(result);
                }
            });
        }
    }).start();

    while(true) {
        queue.take().run();
    }
}