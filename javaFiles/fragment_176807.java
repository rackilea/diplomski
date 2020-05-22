public class FlowerPane extends JPanel {

    JTextField nameField = new JTextField(15);
    JTextField idField = new JTextField(10);
    JTextField colorField = new JTextField(10);
    JCheckBox smellBox = new JCheckBox("Smell Present");
    JCheckBox thornsBox = new JCheckBox("Thorns Present");

    public FlowerPane() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);

        JLabel nameLabel = new JLabel("Name:");
        JLabel idLabel = new JLabel("ID:");
        JLabel colorLabel = new JLabel("Color:");

        add(nameLabel, gbc);
        gbc.gridy++;
        add(idLabel, gbc);
        gbc.gridy++;
        add(idLabel, gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        add(nameField, gbc);
        gbc.gridy++;
        add(idField, gbc);
        gbc.gridy++;
        add(colorField, gbc);

        gbc.gridx = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        add(thornsBox, gbc);
        gbc.gridy++;
        add(smellBox, gbc);
    }

    public Flower create() {
        return new Flower(nameField.getText(), idField.getText(), colorField.getText(), thornsBox.isSelected(), smellBox.isSelected());
    }

}