JButton[] buttons = new JButton[9];
...
for (int i = 0; i < 4; i++){
    buttons[i] = new JButton();
    buttons[i].setFont(new Font("Sans Serif", Font.BOLD , 14));
    buttonEna.setBorderPainted(false);
    // set other properties for button
    panel.add(buttons[i]);
}