import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JavaApplication1013 {

    public static void main(String[] args) {
        new JavaApplication1013();
    }

    public JavaApplication1013() {
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
                frame.add(new PanelHolder());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public enum View {
        MENU,
        TUTORIAL,
        FREEPLAY;
    }

    public interface NavigationController {
        public void showView(View view);
    }

    public class PanelHolder extends JPanel implements NavigationController {

        private CardLayout cardLayout;

        public PanelHolder() {
            cardLayout = new CardLayout();
            setLayout(cardLayout);

            add(new MenuView(this), View.MENU.name());
            add(new TutorialView(this), View.TUTORIAL.name());
            add(new FreePlayView(this), View.FREEPLAY.name());
        }

        @Override
        public void showView(View view) {
            cardLayout.show(this, view.name());
        }

    }

    public abstract class ViewPane extends JPanel {
        private NavigationController controller;

        public ViewPane(NavigationController controller) {
            this.controller = controller;
        }

        public NavigationController getController() {
            return controller;
        }

        protected void showView(View view) {
            controller.showView(view);
        }

    }

    public class MenuView extends ViewPane {

        public MenuView(NavigationController controller) {
            super(controller);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            JButton tut = new JButton("Tutorial");
            JButton freePlay = new JButton("Free Play");

            add(tut, gbc);
            add(freePlay, gbc);

            tut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showView(View.TUTORIAL);
                }
            });
            freePlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showView(View.FREEPLAY);
                }
            });
        }

    }

    public class TutorialView extends ViewPane {

        public TutorialView(NavigationController controller) {
            super(controller);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            JButton menu = new JButton("Menu");

            add(new JLabel("Tutorial"), gbc);
            add(menu, gbc);

            menu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showView(View.MENU);
                }
            });
        }

    }

    public class FreePlayView extends ViewPane {

        public FreePlayView(NavigationController controller) {
            super(controller);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            JButton menu = new JButton("Menu");

            add(new JLabel("Free Play"), gbc);
            add(menu, gbc);

            menu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showView(View.MENU);
                }
            });
        }

    }
}