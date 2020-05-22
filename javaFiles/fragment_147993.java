public JPanel loginLayer(){
    JPanel masterPane = new JPanel(new GridBagLayout);

    JPanel centerPane = new JPanel();
    centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));

    JLabel label = new JLabel("Swing is overly");
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    centerPane.add(label);
    JButton button = new JButton("complicated");
    button.setAlignmentX(Component.CENTER_ALIGNMENT);
    centerPane.add(button);
    JTextField textField = new JTextField(10);
    centerPane.add(textField);

    masterPane.add(centerPane);

    // Add additional borders to providing padding around the center pane
    // as you need

    return masterPane;
}