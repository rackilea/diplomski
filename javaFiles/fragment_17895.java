public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            Animation a = new Animation();
            a.go();
        }
    });
}