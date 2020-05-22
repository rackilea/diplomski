public class LayoutDemo extends JFrame {

    public LayoutDemo() {

        JLabel label1 = new JLabel("label 1");
        JLabel label2 = new JLabel("label 2");
        JLabel label3 = new JLabel("label 3");
        JComboBox<String> combobox = new JComboBox<>();
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();

        JPanel formPanel = new JPanel(new SpringLayout());
        formPanel.add(label1);
        formPanel.add(combobox);
        formPanel.add(label2);
        formPanel.add(field1);
        formPanel.add(label3);
        formPanel.add(field2);

        SpringUtilities.makeCompactGrid(formPanel, 3, 2, 2, 2, 3, 3);

        JLabel longLabel = new JLabel("This is a longer label");
        longLabel.setAlignmentX(CENTER_ALIGNMENT);

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(button1);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(button2);

        JPanel basePanel = new JPanel();
        basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.PAGE_AXIS));
        basePanel.add(formPanel);
        basePanel.add(longLabel);

        add(basePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutDemo();
    }
}