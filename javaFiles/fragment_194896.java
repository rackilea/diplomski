import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
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

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public enum Page {
        MENU("menu"),
        HERE("here"),
        THERE("there");

        private String pageName;

        private Page(String name) {
            pageName = name;
        }

        public String getPageName() {
            return pageName;
        }

    }

    public interface Navigator {
        public void showPage(Page page);
    }

    public class TestPane extends JPanel implements Navigator {

        private CardLayout cardLayout;

        public TestPane() {
            cardLayout = new CardLayout();
            setLayout(cardLayout);
            add(new MenuPanel(this), Page.MENU.getPageName());
            add(new StuffOverHere(), Page.HERE.getPageName());
            add(new StuffOverThere(), Page.THERE.getPageName());
            showPage(Page.MENU);
        }

        @Override
        public void showPage(Page page) {
            cardLayout.show(this, page.getPageName());
        }

    }

    public class StuffOverHere extends JPanel {

        public StuffOverHere() {
            setLayout(new GridBagLayout());
            JLabel label = new JLabel("Over here");
            add(label);
        }

    }
    public class StuffOverThere extends JPanel {

        public StuffOverThere() {
            setLayout(new GridBagLayout());
            JLabel label = new JLabel("Over there");
            add(label);
        }

    }

    public class MenuPanel extends JPanel {

        private final LayoutManager innerLayout = new GridLayout(3, 1, 1, 1);
        private final JToggleButton button1 = new JToggleButton("Stuff over here");
        private final JToggleButton button2 = new JToggleButton("Stuff over there");

        private Navigator navigator;

        public MenuPanel(Navigator navigator) {
            super();
            SwitchHandler sHandler = new SwitchHandler();
            this.setLayout(innerLayout);
            this.add(button1);
            this.add(button2);
            button1.addActionListener(sHandler);
            button2.addActionListener(sHandler);
            this.navigator = navigator;
        }

        class SwitchHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) {
                    navigator.showPage(Page.HERE);
                } else {
                    navigator.showPage(Page.THERE);
                }
            }
        }
    }
}