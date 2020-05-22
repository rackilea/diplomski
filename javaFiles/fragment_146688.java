import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;

/**
 * @see http://stackoverflow.com/a/13756527/230513
 */
public class MenuProblemExample {

    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JMenuBar menuBar = new JMenuBar();
                JMenu fileMenu = new JMenu("File");
                final JMenuItem openItem = new JMenuItem("open");
                openItem.setEnabled(false);
                fileMenu.add(openItem);
                menuBar.add(fileMenu);
                JMenu editMenu = new JMenu("Edit");
                editMenu.add(new JMenuItem("select all"));
                menuBar.add(fileMenu);
                menuBar.add(editMenu);
                frame.setJMenuBar(menuBar);
                frame.add(new JToggleButton(new AbstractAction("Toggle") {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JToggleButton b = (JToggleButton) e.getSource();
                        openItem.setEnabled(b.isSelected());
                    }
                }));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}