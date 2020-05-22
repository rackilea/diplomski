public static void main(String args[]) throws Exception
{
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                Visual v1 = new Visual();
                v1.connect("COM4", "1");
                v1.setVisible(true);

                Visual v2 = new Visual();
                v2.connect("COM6", "2");
                v2.setVisible(true);
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }
    });
}