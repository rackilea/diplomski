import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FocusTraversalDemo extends JComponent {

    List<Component> components = new ArrayList<Component>();

    public FocusTraversalDemo() {
        setFocusTraversalPolicyProvider(true);
        setLayout(new GridLayout(5, 5, 10, 10));
        initComponents();
        setFocusTraversalPolicy(new RandomFocusTraversalPolicy(components));
    }

    private void initComponents() {
        for (int i = 0; i < 25; i++) {
            final JButton button = new JButton("Button " + i);
            final Color defaultColor = button.getForeground();
            button.addFocusListener(new FocusListener(){
                @Override
                public void focusGained(FocusEvent e) {
                    button.setForeground(Color.BLUE);
                }
                @Override
                public void focusLost(FocusEvent e) {
                    button.setForeground(defaultColor);
                }
            });
            this.add(button);
            components.add(button);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new FocusTraversalDemo());
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class RandomFocusTraversalPolicy extends FocusTraversalPolicy {

        private List<Component> comps;

        public RandomFocusTraversalPolicy(List<Component> comps) {
            this.comps = comps;
        }

        @Override
        public Component getComponentAfter(Container aContainer, Component aComponent) {
            return comps.get(getRandomIndex());

        }

        @Override
        public Component getComponentBefore(Container aContainer, Component aComponent) {
            return comps.get(getRandomIndex());
        }

        @Override
        public Component getFirstComponent(Container aContainer) {
            return comps.get(0);
        }

        @Override
        public Component getLastComponent(Container aContainer) {
            return comps.get(comps.size() - 1);
        }

        @Override
        public Component getDefaultComponent(Container aContainer) {
            return comps.get(0);
        }

        private int getRandomIndex() {
            Random random = new Random();
            return random.nextInt(comps.size());
        }
    }
}