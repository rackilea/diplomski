import javax.swing.*;

public class TestSwapPanel extends JPanel {
    private static final int GAP = 20;
    private SwapPanel swapPanel = new SwapPanel();

    public TestSwapPanel() {
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        add(swapPanel);
    }

    private static void createAndShowGui() {
        TestSwapPanel mainPanel = new TestSwapPanel();

        JFrame frame = new JFrame("Swap Components");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}