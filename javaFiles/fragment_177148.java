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
                JFrame f = new JFrame("Split Pane To Right");
                f.add(sp);
                f.pack();
                // sp now has a non-zero size!
                sp.setDividerLocation(1.0);
                f.setLocationByPlatform(true);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }
}