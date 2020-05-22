public class PanelMapDemo extends javax.swing.JFrame {
private static final long serialVersionUID = 1L;

public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            PanelMapDemo demoFrame = new PanelMapDemo("PanelMapDemo");
            demoFrame.setVisible(true);
        }
    });
}

public PanelMapDemo(String title) {
    super(title);
    setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    add(new PanelMap());
    setSize(new java.awt.Dimension(400, 200));
    setLocationRelativeTo(null);
 }
}