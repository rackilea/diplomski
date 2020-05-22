public void mouseClicked(MouseEvent arg0) {
    TEXT.setText("ON");
    (new Thread() {
        public void run() {
            myfunction();
        }
    }).start();
}