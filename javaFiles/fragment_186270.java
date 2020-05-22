import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

/** @see http://stackoverflow.com/a/14630345/230513 */
public class Test {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menu = new JMenuBar();
        JMenu actions = new JMenu("Aktionen");
        JMenuItem addItem = new JMenuItem("Add");
        addItem.setToolTipText("Add new Item");
        menu.add(actions);
        actions.add(addItem);
        JToolBar toolbar = new JToolBar("Tools");
        toolbar.add(menu);
        f.add(toolbar);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}