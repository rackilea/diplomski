import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public class CopyAction extends AbstractAction {

        private JList list;

        public CopyAction(JList list) {
            putValue(NAME, "Copy");
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
            putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            putValue(SELECTED_KEY, "Copy stuff");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("All your copies belong to us");
        }

        public JList getList() {
            return list;
        }

    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                TestPane tp = new TestPane();
                CopyAction copyAction = new CopyAction(tp.getListOfStuff());

                JMenuBar mb = new JMenuBar();
                JMenu menu = new JMenu("Edit");
                mb.add(menu);
                menu.add(copyAction);

                JFrame frame = new JFrame("Testing");
                frame.setJMenuBar(mb);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JList listOfStuff;

        public TestPane() {
            setLayout(new BorderLayout());
            listOfStuff = new JList();
            add(new JScrollPane(listOfStuff));

            CopyAction copyAction = new CopyAction(listOfStuff);
            listOfStuff.getActionMap().put("copy", copyAction);
        }

        public JList getListOfStuff() {
            return listOfStuff;
        }

    }

}