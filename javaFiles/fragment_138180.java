public class BallPanel extends JPanel {
    public BallPanel() {
        JPanel panel = new JPanel();
        JButton go = new JButton("GO");
        JButton stop = new JButton("STOP");
        panel.add(go);
        panel.add(stop);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.SOUTH);
    }
}