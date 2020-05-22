public class Test extends JPanel {
    public Test() {
        super();
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWeights = new double[] { 1.0 }; // expands the  1rst cell of the layout on the vertical axis
        gridBagLayout.rowWeights = new double[] { 1.0 }; // expands the 1rst cell of the layout on the horizontal axis
        setLayout(gridBagLayout);

        JLabel label = new JLabel("test");          
        label.setOpaque(true);
        label.setBackground(Color.RED);
        label.setPreferredSize(new Dimension(100, 95));
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.gridx = 0; // set label cell (0,0)
        gbc_label.gridy = 0;
        gbc_label.insets = new Insets(0, 0, 5, 5);

        add(label, gbc_label);

        JButton button = new JButton("button");
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.gridx = 0; // set buttoncell (0,0)
        gbc_button.gridy = 0;
        gbc_button.anchor = GridBagConstraints.SOUTHEAST;

        add(button, gbc_button);
        button.setPreferredSize(new Dimension(100, 25));
    }
}