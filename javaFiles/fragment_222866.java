public class TestPane extends JPanel {

    public TestPane() {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JTextArea intro = new JTextArea(4, 20);
        JTextArea moreText = new JTextArea(4, 20);

        JLabel question = new JLabel("Question 1");
        JTextField answer = new JTextField(20);
        JButton btn = new JButton("Done");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2, 2, 2, 2);

        add(new JScrollPane(intro), gbc);
        gbc.gridy++;
        add(new JScrollPane(moreText), gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.insets = new Insets(20, 2, 2, 2);
        gbc.anchor = GridBagConstraints.WEST;

        add(question, gbc);
        gbc.gridx++;
        add(answer, gbc);

        gbc.insets = new Insets(80, 2, 2, 2);
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(btn, gbc);

    }

}