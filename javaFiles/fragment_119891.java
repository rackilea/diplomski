public static void main(String[] args) throw InterruptedException {
    EventQueue.invokeLater( new Runnable() {
        public void run() {
            P p = new P();
            p.repaint();
        }
    } );
}