import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwitchPanel extends JApplet{

    private String currentView;
    private List<String> viewNames;

    @Override
    public void init() {
        final CardLayout cardLayout = new CardLayout();
        setLayout(cardLayout);

        Navigator navi = new Navigator() {

            @Override
            public void next() {
                int index = viewNames.indexOf(currentView);
                if (index > -1) {
                    index++;
                    if (index < viewNames.size()) {
                        currentView = viewNames.get(index);
                        cardLayout.show(getContentPane(), currentView);
                    }
                }
            }

            @Override
            public void previous() {
                int index = viewNames.indexOf(currentView);
                if (index > -1) {
                    index--;
                    if (index >= 0) {
                        currentView = viewNames.get(index);
                        cardLayout.show(getContentPane(), currentView);
                    }
                }
            }
        };

        MainPane mainPane = new MainPane(navi);
        LastPane lastPane = new LastPane(navi);

        viewNames = new ArrayList<>(2);
        viewNames.add("main");
        viewNames.add("last");

        add(mainPane, "main");
        add(lastPane, "last");
        currentView = "main";

        cardLayout.show(getContentPane(), "main");

    }

    public interface Navigator {

        public void next();
        public void previous();

    }

    public class MainPane extends JPanel {

        private Navigator navigator;

        public MainPane(Navigator navi) {
            this.navigator = navi;
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            JButton btn = new JButton("Next >");

            add(new JLabel("Main"), gbc);
            add(btn, gbc);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    navigator.next();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

    public class LastPane extends JPanel {

        private Navigator navigator;

        public LastPane(Navigator navi) {
            this.navigator = navi;
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            JButton btn = new JButton("< Previous");

            add(new JLabel("Last"), gbc);
            add(btn, gbc);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    navigator.previous();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

}