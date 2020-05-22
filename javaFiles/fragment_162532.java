public class GuiExample extends JPanel {
    public GuiExample() {
        JPanel gamePanel = new JPanel();
        gamePanel.setBackground(Color.GREEN);
        gamePanel.setPreferredSize(new Dimension(300, 400));

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.WHITE);

        JPanel previewPanel = new JPanel();
        previewPanel.setBackground(Color.BLUE);
        previewPanel.setPreferredSize(new Dimension(100, 100));

        JPanel pointsPanel = new JPanel();
        pointsPanel.setBackground(Color.RED);
        pointsPanel.setPreferredSize(new Dimension(100, 50));

        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setPreferredSize(new Dimension(100, 400));
        infoPanel.add(previewPanel);
        infoPanel.add(pointsPanel);

        add(gamePanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.EAST);
    }
    public static void main(String s[]) {
        JFrame frame = new JFrame("Java Rules");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GuiExample());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}