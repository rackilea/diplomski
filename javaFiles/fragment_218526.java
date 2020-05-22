final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
ExecutorService ex = Executors.newFixedThreadPool(1000);
for (;;) {
    ex.execute(new Runnable() {
        public void run() {
            try {
                f.format(new Date(new Random().nextLong()));
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        };
    });
}