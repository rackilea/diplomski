public static void main(String[] args) {
    int num = 0;

    Thread thread = new Thread() {
        @Override
        public void run() {
            System.out.println("Anonymous " + num);
        }
    };
    thread.start();
}