public static void main(String[] args) {
    ActionListener al = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            m.moveRandomly();
            updateMatrix(m);
        }
    }
    javax.swing.Timer time = new Timer(1000, al);
    time.start();
}