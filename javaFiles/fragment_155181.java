JButton [] buttons = new JButton[n];
for(int i=0;i<n;i++){
    buttons[i] = new JButton("label "+ i);
    buttons[i].set...
    buttons[i].set...
    gridlayout.add(buttons[i]);
}

borderlayout.add(gridlayout, BorderLayout.CENTER);
panel.setLayout(borderlayout);