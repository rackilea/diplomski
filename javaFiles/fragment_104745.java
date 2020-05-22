for(int i = 0; i < buttons.length; i++){
    buttons[i] = new JButton("" + a_btnNames[i]); //create button & add to array
    buttons[i].addActionListener(this); //add an action listener to the current button
    panel.add(buttons[i]); //add that same button to the panel

}