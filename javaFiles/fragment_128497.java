public static class DrawFrame {

    public DrawFrame() {
        DrawPanels panelFrame = new DrawPanels();
        JFrame mainFrame = new JFrame();
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(480, 800);
        mainFrame.setTitle("Title");
        mainFrame.setResizable(false);
        mainFrame.add(panelFrame);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}

public class DrawPanels extends JPanel {

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    public DrawPanels() {
        setLayout(new GridLayout(1, 3));
        panel1.setBackground(Color.ORANGE);
        panel2.setBackground(Color.BLACK);
        panel3.setBackground(Color.RED);
        panel1.setBorder(new LineBorder(Color.BLACK));
        panel2.setBorder(new LineBorder(Color.BLACK));
        panel3.setBorder(new LineBorder(Color.BLACK));

        panel1.add(new DrawBlock());
        panel2.add(new DrawBlock());
        panel3.add(new DrawBlock());

        add(panel1);
        add(panel2);
        add(panel3);

    }
}