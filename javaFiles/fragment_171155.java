private void test(final int i) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            jList1.setSelectedIndex(i);
            System.out.println("javax.swing.SwingUtilities.isEventDispatchThread()=" + javax.swing.SwingUtilities.isEventDispatchThread());
            jList1.ensureIndexIsVisible(i);
        }
    });
}