public class GuestFixturesPanel extends JPanel {
    public GuestFixturesPanel() {
        this.setLayout(new BorderLayout());

        JPanel guestCenterJPanel = new JPanel(new BorderLayout());

        JPanel guestSouthPanel = new JPanel(new FlowLayout());
        JButton guestBackButton = new JButton("Back");
        guestSouthPanel.add(guestBackButton);

        add(guestCenterJPanel, BorderLayout.CENTER);
        add(guestSouthPanel, BorderLayout.SOUTH);

        guestCenterJPanel.setBackground(Color.BLUE);
        guestSouthPanel.setBackground(Color.GREEN);
    }
}