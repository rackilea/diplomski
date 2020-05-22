static JLabel designTextField()
{
    JLabel display = new JLabel("---------------");
    Border withoutBorder = new LineBorder(new Color(0, 0, 0), 0, true);
    display.setBorder(withoutBorder);   
    //display.setFont(new Font("Gill Sans MT", Font.BOLD, 40));
    return (display);
}

public static void makeSimpleGUI(Container pane) {
    JButton button;

    pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    pane.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 0.5;
    gbc.gridx = 0;
    gbc.gridy = 0;

    //Add of jlabel to display results
    pane.add(designTextField(), gbc);