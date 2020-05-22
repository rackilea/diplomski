public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                GUI myGUI = new GUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}