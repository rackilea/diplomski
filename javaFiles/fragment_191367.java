static int showQuestion(String dialogTitle, String question, String[] answers) {
    Box box = new Box(BoxLayout.Y_AXIS);
    box.add(new JLabel(question));

    JRadioButton[] radioButtons = new JRadioButton[answers.length];
    ButtonGroup buttonGroup = new ButtonGroup();
    for (int i = 0; i < answers.length; i++) {
        radioButtons[i] = new JRadioButton(answers[i]);
        buttonGroup.add(radioButtons[i]);
        box.add(radioButtons[i]);
    }

    for (;;) {
        if (JOptionPane.CLOSED_OPTION == JOptionPane.showConfirmDialog(null, box, dialogTitle, JOptionPane.DEFAULT_OPTION)) {
            return -1;
        }
        for (int i = 0; i < radioButtons.length; i++) {
            if (radioButtons[i].isSelected()) return i;
        }
    }
}