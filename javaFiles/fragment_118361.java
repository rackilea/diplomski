private static void luanch() {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                Frame1 window = new Frame1();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}