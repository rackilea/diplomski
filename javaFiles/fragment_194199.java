public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Later: " + System.currentTimeMillis());
        }
    });
    try {
        System.out.println("now: " + System.currentTimeMillis());
        // System.exit(0);
    } finally {
        System.out.println("finally: " + System.currentTimeMillis());
    }
}