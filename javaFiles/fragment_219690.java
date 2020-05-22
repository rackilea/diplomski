for(int i=0; i<10; i++){
        buttons[i] = new JButton(playerN);
}
//do this instead
for(int i=0; i<10; i++){
    JButton jBut = new JButton(playerN);
    buttonsList.add(jBut);
}

//Added buttons to panel with for loop
for(int i=0; i<10; i++){
    gridPanel.add(buttons[i]);
}
//Do this instead
//Added buttons to panel with for loop
for(int i=0; i<10; i++){
    gridPanel.add(buttonsList.get(i));
}