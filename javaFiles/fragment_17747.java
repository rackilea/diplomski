public static void main(String[] args) throws Exception {
    final ExecutorService es = Executors.newSingleThreadExecutor();
    es.execute(new Runnable() {

        @Override
        public void run() {
            //do stuff
        }
    });
}