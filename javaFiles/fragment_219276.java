private static String[] letters = { "A", "B", "C", "D", "E", "F",
    "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
    "S", "T", "U", "V", "W", "X", "Y", "Z" };
private JButton[] letterButtons = new JButton[letters.length];

private void initComponents() {
    ActionListener al = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            Object src = evt.getSource();
            if (evt instanceof JButton) {
                currentLetter = ((JButton) src).getText();
                // do something with letter
            } // else something seriously wrong
        }
    };
    for (int i = 0; i < letters.length; ++i) {
        letterButtons[i] = new JButton(letters[i]);
        letterButtons[i].addActionListener(al);
    }
    . . .
    // add all the buttons to the user interface
    . . .
}