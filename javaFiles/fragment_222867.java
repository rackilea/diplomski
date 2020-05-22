public class TestPane extends JPanel {

    public TestPane() {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JTextArea intro = new JTextArea(4, 20);
        JTextArea moreText = new JTextArea(4, 20);

        JLabel question1 = new JLabel("Question 1");
        JTextField answer1 = new JTextField(20);
        JLabel question2 = new JLabel("Question 2");
        JTextField answer2 = new JTextField(20);
        JButton btn = new JButton("Done");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2, 2, 2, 2);

        add(new JScrollPane(intro), gbc);
        gbc.gridy++;
        add(new JScrollPane(moreText), gbc);

        gbc.gridy++;
        gbc.insets = new Insets(20, 2, 2, 2);
        gbc.anchor = GridBagConstraints.WEST;

        add(question1, gbc);
        gbc.gridx++;
        add(answer1, gbc);

        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.gridy++;
        gbc.gridx = 0;
        add(question2, gbc);
        gbc.gridx++;
        add(answer2, gbc);

        gbc.insets = new Insets(80, 2, 2, 2);
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(btn, gbc);

    }

}