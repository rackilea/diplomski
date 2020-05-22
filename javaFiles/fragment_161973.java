public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            javax.swing.JFrame fr = new NewJFrame();
            com.sun.awt.AWTUtilities.setWindowOpacity(fr, 0.7 f);
            fr.setVisible(true);
        }
    });
}