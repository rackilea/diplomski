import java.awt.*;
import javax.swing.*;

public class JMenuItemPackTest {
  public JMenuBar makeMenuBar() {
    JMenuItem label = new JMenuItem("Up to date: 3.5-beta");
    label.setBackground(Color.GREEN);
//     UpdateMenuItem label = new UpdateMenuItem("Up to date: 3.5-beta") {
//       @Override public void setDownloadAvailable(final VersionId version) {
//         super.setDownloadAvailable(version);
//         Container c = SwingUtilities.getUnwrappedParent(this);
//         if (c instanceof JPopupMenu) {
//           ((JPopupMenu) c).pack();
//         }
//       }
//     };

    JMenu update = new JMenu("Updates");
    update.add(new JCheckBoxMenuItem("Auto-check for updates"));
    update.add(new JCheckBoxMenuItem("Auto-download"));
    update.add(label);

    JMenu menu = new JMenu("Help");
    menu.add(update);

    (new Timer(5000, e -> {
      //...
      label.setText("Click to download: 3.5-beta");
      label.setBackground(Color.ORANGE);
      update.getPopupMenu().pack();
      //or:
      //Container c = SwingUtilities.getUnwrappedParent(label);
      //if (c instanceof JPopupMenu) {
      //  ((JPopupMenu) c).pack();
      //}
    })).start();

    JMenuBar menubar = new JMenuBar();
    menubar.add(menu);
    return menubar;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.setJMenuBar(new JMenuItemPackTest().makeMenuBar());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}