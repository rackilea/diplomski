public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              JFrame f = new JFrame("Test");
              JTabbedPane tp = new JTabbedPane();
              JTextField tf = new JTextField();
              tf.enableInputMethods(false); // disable IM
              tp.addTab("tab 1", tf);
              f.add(tp);
              f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              f.pack();
              f.setLocationRelativeTo(null);
              f.setVisible(true);
            }
        });
    }
}