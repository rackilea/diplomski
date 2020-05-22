static int state;
static public void main(String... args) {
    state = 0;                   // (1)
    Thread t = new Thread() {
        public void run() {
            state = state + 1;   // (2) 
        }
    };
    t.start();
    t.join();
    System.out.println(state);  // (3)
}