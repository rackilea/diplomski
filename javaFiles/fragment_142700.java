final JPanel mainPanel = new JPanel(new CardLayout());
final JTextField textField = new JTextField(10);

Action action = new AbstractAction("Login") {
    public void actionPerformed(ActionEvent e) {
        /* Check user credentials here. */
        boolean b = textField.getText().equals("true");

        CardLayout cl = (CardLayout)(mainPanel.getLayout());
        cl.show(mainPanel, b ? e.getActionCommand() : "login");
    }
};

JButton loginButton = new JButton(action);
loginButton.setActionCommand("quiz");

JPanel loginPanel = new JPanel();
loginPanel.add(textField);
loginPanel.add(loginButton);

JPanel quizPanel = new JPanel();
quizPanel.add(new JLabel("Quiz"));

mainPanel.add(loginPanel, "login");
mainPanel.add(quizPanel, "quiz");

JFrame f = new JFrame();
f.setContentPane(mainPanel);
f.pack();
f.setVisible(true);
f.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
});