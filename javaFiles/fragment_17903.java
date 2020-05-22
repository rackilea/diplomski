public static void main(String[] args) {
    Thread thread = new Thread() {

        @Override
        public void run() {
            System.out.println("Anonymous " + AnonymousThreadDemo.this); // compile error
        }
    };
    thread.start();
}