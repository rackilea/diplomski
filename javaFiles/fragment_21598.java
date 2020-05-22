public static void main(String[] args) {

    JFrame frame = new JFrame();
    JPanel container = new JPanel();
    JPanel iconLabelPanel = new JPanel();

    String TEXT_FIELD_TEXT = "Hover over the logout label.";

    JLabel icon = new JLabel(new ImageIcon("C:\\Users\\Gary\\Google Drive\\Pictures\\puush\\ss (2015-02-19 at 06.00.00).png"));
    JLabel label = new JLabel("Logout!");
    JTextField textField = new JTextField(TEXT_FIELD_TEXT);

    //Add a mouse motion listener for the JLabel
    label.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            //Set text of another component
            textField.setText("You're over Logout!");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //Set text of another component
            textField.setText(TEXT_FIELD_TEXT);
        }
    });


    //Add components and set parameters for iconLabelPanel
    iconLabelPanel.setLayout(new BoxLayout(iconLabelPanel, BoxLayout.PAGE_AXIS));
    iconLabelPanel.add(icon);
    iconLabelPanel.add(label);

    //Add components and set parameters for container
    container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
    container.add(iconLabelPanel);
    container.add(textField);

    //Set parameters for frame
    frame.add(container);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(400, 400);
    frame.setVisible(true);
}