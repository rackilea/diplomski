class StartFrame extends JFrame implements ActionListener {
    private JFrame adminFrame;
    private JFrame userFrame;
    ...

    // add construtor to initialize adminFrame and userFrame appropriately
    ...

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminBut) {
            this.setVisible(false);
            adminFrame.setVisible(true);
        }
        if (e.getSource() == userBut) {
            this.setVisible(false);
            userFrame.setVisible(true);
        }
    }
}