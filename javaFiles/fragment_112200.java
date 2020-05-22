public class ButtonPane extends JPanel {

    public ButtonPane() {
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(8, 8, 8, 8));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(2, 2, 2, 2);

        add(new JButton("Button 1"), gbc);
        add(new JButton("Button 2"), gbc);
        add(new JButton("Button 3"), gbc);
    }

}