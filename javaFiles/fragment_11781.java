public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
       @Override
       public void run() {
           AppFrame frame = new AppFrame();
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
   });
}