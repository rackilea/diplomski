import net.miginfocom.swing.MigLayout;
import java.awt.*;
import javax.swing.*;

public class GridBagLayoutDemo {
    final static boolean RIGHT_TO_LEFT = false;

    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        pane.setLayout(new MigLayout("insets 0, gap 0, wrap", "[][fill, grow][fill, grow][][]", "[fill]"));

        addType1(pane, Color.BLACK, Color.BLUE, Color.GREEN, Color.RED, Color.BLUE);
        addType2(pane, Color.MAGENTA, Color.PINK, Color.BLACK, Color.PINK);
        addType3(pane, Color.GRAY, Color.ORANGE, Color.RED, Color.ORANGE);
        addType3(pane, Color.BLACK, Color.WHITE, Color.GREEN, Color.BLUE);
        addType3(pane, Color.DARK_GRAY, Color.YELLOW, Color.WHITE, Color.ORANGE);
        addType2(pane, Color.GREEN, Color.BLUE, Color.RED, Color.BLACK);
        addType2(pane, Color.DARK_GRAY, Color.WHITE, Color.YELLOW, Color.GREEN);
    }

    private static void addType1(Container pane, Color c1, Color c2, Color c3, Color c4, Color c5) {
        pane.add(new TestPanel(c1));
        pane.add(new TestPanel(c2));
        pane.add(new TestPanel(c3));
        pane.add(new TestPanel(c4));
        pane.add(new TestPanel(c5));
    }

    private static void addType2(Container pane, Color c1, Color c2, Color c3, Color c4) {
        pane.add(new TestPanel(c1));
        pane.add(new TestPanel(c2), "spanx 2");
        pane.add(new TestPanel(c3));
        pane.add(new TestPanel(c4));
    }

    private static void addType3(Container pane, Color c1, Color c2, Color c3, Color c4) {
        pane.add(new TestPanel(c1));
        pane.add(new TestPanel(c2), "spanx 2, pushy, hmin pref+40");
        pane.add(new TestPanel(c3));
        pane.add(new TestPanel(c4));
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("MigLayout Practice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

class TestPanel extends JPanel {
    public TestPanel(Color myColor) {
        this.setBackground(myColor);
    }
}