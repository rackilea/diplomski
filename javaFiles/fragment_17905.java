public static void main(String[] args) {
    Thread thread = new Thread() {
        int num = 0;

        @Override
        public void run() {
            System.out.println("Anonymous " + num);
        }
    };
    thread.start();
}