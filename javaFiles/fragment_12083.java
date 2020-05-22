import java.awt.CardLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public @SuppressWarnings("serial")
class SwappingComponent extends JPanel {
    private static final String SHOW = "show";
    private static final String HIDE = "hide";
    JComponent component;
    CardLayout cardLayout = new CardLayout();

    public SwappingComponent(JComponent component) {
        setLayout(cardLayout);
        this.component = component;
        add(component, SHOW);
        add(new JLabel(), HIDE);
    }

    public JComponent getComponent() {
        return component;
    }

    public void showComponent(boolean show) {
        String key = show ? SHOW : HIDE;
        cardLayout.show(this, key);
    }

}