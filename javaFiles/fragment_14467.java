JPanel centerPanel = new JPanel();
    centerPanel.setLayout (new GridLayout ()); //added
    this.add(centerPanel,BorderLayout.CENTER);
    JLabel mapLabel = new JLabel("Test_String");
    mapLabel.setHorizontalAlignment(SwingConstants.CENTER); //added
    mapLabel.setVerticalAlignment(SwingConstants.CENTER); //added
    centerPanel.add(mapLabel);
    centerPanel.setBorder (new EtchedBorder(Color.black,Color.black));
    centerPanel.setBackground (Color.white);