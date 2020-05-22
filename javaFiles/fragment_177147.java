import javax.swing.*;

class SplitPaneDefault {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JSplitPane sp = new JSplitPane(
                    JSplitPane.HORIZONTAL_SPLIT,
                    new JTree(),
                    new JTree());
                sp.setOneTouchExpandable(true);
                sp.setDividerLocation(0.0);
                JOptionPane.showMessageDialog(null, sp);
            }
        });
    }
}