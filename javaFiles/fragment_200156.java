private final String[] bText = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", ".", "=", "/", "(", ")", "C", "CE"};
private JButton[] buttons = new JButton[bText.length];

public TestPane() {
    setLayout(new GridLayout(0, 3));
    for (int index = 0; index < bText.length; index++) {
        String text = bText[index];
        JButton btn = new JButton(text);
        buttons[index] = btn;
        btn.addActionListener(this);
        add(btn);
    }
}

@Override
public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source instanceof JButton) {
        JButton btn = (JButton)source;
        String text = btn.getText();
        if (text.matches("^[0-9]")) {
            System.out.println(text + " is a number");
        } else if (text.matches("^[=/\\(\\)*=\\-\\+]")) {
            System.out.println(text + " is an operator");
        } else {
            System.out.println(text + " is some other command");
        }
    }
}