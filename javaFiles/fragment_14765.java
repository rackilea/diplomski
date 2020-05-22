import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class PassRef {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }

    private static void createAndShowGui() {
        MyMain mainPanel = new MyMain();
        JFrame frame = new JFrame("Pass Reference");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}

class MyMain extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = 450;
    private CardLayout cardLayout = new CardLayout();
    private MenuView menuView = new MenuView(this);
    private ActionView1 actionView1 = new ActionView1(this);

    public MyMain() {
        setLayout(cardLayout);
        add(menuView, MenuView.NAME);
        add(actionView1, ActionView1.NAME);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        } else {
            return new Dimension(PREF_W, PREF_H);
        }
    }

    public void showCard(String key) {
        cardLayout.show(this, key);
        // or swap by hand if you don't want to use CardLayout
        // but remember to revalidate and repaint whenever doing it by hand
    }
}

class MenuView extends JPanel {
    public static final String NAME = "Menu View";

    public MenuView(MyMain myMain) {
        setName(NAME);
        setBorder(BorderFactory.createTitledBorder("Menu"));
        add(new JButton(new GoToAction("Action 1", ActionView1.NAME, myMain)));
    }

}

class ActionView1 extends JPanel {
    public static final String NAME = "Action View 1";

    public ActionView1(MyMain myMain) {
        setName(NAME);
        setBorder(BorderFactory.createTitledBorder(NAME));
        add(new JButton(new GoToAction("Main Menu", MenuView.NAME, myMain)));
    }

}

class GoToAction extends AbstractAction {
    private String key;
    private MyMain myMain;

    public GoToAction(String name, String key, MyMain myMain) {
        super(name);
        this.key = key;
        this.myMain = myMain;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myMain.showCard(key);
    }
}