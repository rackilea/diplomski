public static void main(String[] args) {
    Runnable r = new Runnable() {

        @Override
        public void run() {
            ImageTimeTunnel itt = new ImageTimeTunnel();

            JFrame f = new JFrame("Image Time Tunnel");
            f.add(itt.getGUI());
            // Ensures JVM closes after frame(s) closed and
            // all non-daemon threads are finished
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // ensures the frame is the minimum size it needs to be
            // in order display the components within it
            f.pack();

            // See http://stackoverflow.com/a/7143398/418556 for demo.
            // f.setLocationByPlatform(true);
            f.setLocationRelativeTo(null);

            // should be done last, to avoid flickering, moving,
            // resizing artifacts.
            f.setVisible(true);
        }
    };
    // Swing GUIs should be created and updated on the EDT
    // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
    SwingUtilities.invokeLater(r);
}