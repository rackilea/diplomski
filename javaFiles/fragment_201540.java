JPanel panel = new JPanel(new GridLayout(0,1));
    JRadioButton myRadio;
    for(int i = 0; i<100; i++){
        myRadio = new JRadioButton("text" + i);
        panel.add(myRadio);
     }
    JScrollPane scrollPane = new JScrollPane(panel);