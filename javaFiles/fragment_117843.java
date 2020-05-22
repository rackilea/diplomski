public static void main(String args[]) {

    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Form1 form1 = new Form1();
                form1.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                form1.setSize(300, 200);
                form1.setLocationRelativeTo(null);
                form1.setVisible(true);
            }
        });    
}