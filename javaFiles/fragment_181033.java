List<Runnable> runnables = new ArrayList<Runnable>();
int outer = 0;
for (int i = 0; i < 10; i++) {
    int inner = 0;
    runnables.add(new Runnable() {
        public void run() {
            outer++;
            inner++;
        }
    });
}