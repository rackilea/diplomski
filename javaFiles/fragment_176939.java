public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            empManUI empUI = new empManUI();
            empUI.layout();
        }
    });
}