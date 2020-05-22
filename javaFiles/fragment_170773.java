private static final String DIGIT_COMMAND = "digit";

// Assign the action command of each button as DIGIT_COMMAND...

...

public void actionPerformed(ActionEvent e) {
    if (DIGIT_COMMAND.equals(e.getActionCommand()) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();
        display.setText(text);
        System.out.println(text);
    } else {
        // Handle other commands
    }
}