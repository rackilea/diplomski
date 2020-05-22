import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {

    private List<AbstractViewPanel> registeredViews;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Test().init();
            }
        });
    }

    private void init() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(0, 1));

        registeredViews = new ArrayList<AbstractViewPanel>();
        for (int i = 0; i < 2; i++) {
            registeredViews.add(new SomeView());
            registeredViews.add(new SomeOtherView());
        }
        for (AbstractViewPanel view : registeredViews) {
            f.add(view);
        }

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    abstract class AbstractViewPanel extends JPanel {

        public AbstractViewPanel() {
            add(new JLabel(getClass().toString()));
        }
    }

    abstract class AbstractListView extends AbstractViewPanel {
    }

    class SomeView extends AbstractViewPanel {
    }

    class SomeOtherView extends AbstractListView {
    }
}