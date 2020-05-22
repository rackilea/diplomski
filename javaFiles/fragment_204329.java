import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class TestAboutMenu {

    protected void initUI() {
        final JFrame frame = new JFrame("test");
        JMenuBar bar = new JMenuBar();
        JMenu help = new JMenu("Help");
        help.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                showAboutDialog(frame);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void menuCanceled(MenuEvent e) {
                // TODO Auto-generated method stub

            }
        });
        JMenuItem about = new JMenuItem(new AbstractAction("About") {

            @Override
            public void actionPerformed(ActionEvent e) {
                showAboutDialog(frame);
            }
        });
        help.add(about);
        bar.add(help);
        frame.setJMenuBar(bar);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    protected void showAboutDialog(final JFrame frame) {
        JDialog dialog = new JDialog(frame);
        dialog.add(new JLabel("About this program"));
        dialog.setModal(true);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestAboutMenu().initUI();
            }
        });
    }
}