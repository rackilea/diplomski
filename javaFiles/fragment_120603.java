public class GUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 400);
        JButton button = new JButton("Click me");
        button.setPreferredSize(new Dimension(200, 40));
        JPanel panel = new JPanel();
        panel.add(button);
        JScrollPane scrollableArea = new JScrollPane(panel);
        frame.add(scrollableArea);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}