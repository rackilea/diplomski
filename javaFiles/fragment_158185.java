import java.awt.*;
import javax.swing.*;

public class JSplitProblem extends JFrame {

    private static final long serialVersionUID = 1L;
    private JSplitPane mainSplittedPane;

    public JSplitProblem() {
        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.X_AXIS));
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JPanel red = new JPanel();
        red.setBackground(Color.red);
        leftPanel.add(red);
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        JPanel blue = new JPanel();
        blue.setBackground(Color.blue);
        rightPanel.add(blue);
        upperPanel.add(leftPanel);
        upperPanel.add(rightPanel);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.black);

        mainSplittedPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upperPanel, bottomPanel);
        mainSplittedPane.setOneTouchExpandable(true);
        mainSplittedPane.setDividerLocation(0.5);

        add(mainSplittedPane);
        setPreferredSize(new Dimension(400, 300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        pack();
        restoreDefaults();
    }

    private void restoreDefaults() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                mainSplittedPane.setDividerLocation(mainSplittedPane.getSize().height /2);
                //mainSplittedPane.setDividerLocation(mainSplittedPane.getSize().width /2);
            }
        });
    }

    public static void main(String[] args) {
        JSplitProblem jSplitProblem = new JSplitProblem();
    }
}