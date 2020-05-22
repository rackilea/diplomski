import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.DesktopPaneUI;

public class AddingInternalFramestoaJDesktopPane {
  public static void main(final String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JDesktopPane desktop = new JDesktopPane();
    desktop.setUI(new DesktopPaneUI() {
    @Override
        public void installUI(JComponent c) {
            // TODO Auto-generated method stub
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
            super.installUI(c);
        }   
    });
    JInternalFrame internalFrame = new JInternalFrame("Can Do All", true, true, true, true);
    desktop.add(internalFrame);
    internalFrame.setBounds(25, 25, 200, 100);
    JLabel label = new JLabel(internalFrame.getTitle(), JLabel.CENTER);
    internalFrame.add(label, BorderLayout.CENTER);
    internalFrame.setVisible(true);
    frame.add(desktop, BorderLayout.CENTER);
    frame.setSize(500, 300);
    frame.setVisible(true);
  }
}