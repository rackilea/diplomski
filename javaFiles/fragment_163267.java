import javax.swing.*;
import java.awt.*;

public class Example {

    private static void setup() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setFocusable(true);

        JSplitPane pane= new JSplitPane();
        pane.setResizeWeight(1.0);
        pane.setRightComponent(new JPanel());

        JPanel myPanel = new JPanel()
        {
            @Override
            public Dimension getMinimumSize()
            {
                return new Dimension(50, 50);
            }
        };
        myPanel.setLayout(new FlowLayout());

        for(int i=0; i<20; i++) myPanel.add(new JLabel("hello"));

        pane.setLeftComponent(myPanel);

        frame.add(pane);

        frame.pack();
        frame.setVisible(true);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                pane.setDividerLocation(0.5f);
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setup();
            }
        });
    }
}