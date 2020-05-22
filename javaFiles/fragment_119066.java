JButton[] buttons = new JButton[3];
for(int i = 0;i < 3; i++) {
    buttons[i] = new JButton(String.valueOf(i));
    buttons[i].addActionListener(new Numbers());
    add(buttons[i]);
}