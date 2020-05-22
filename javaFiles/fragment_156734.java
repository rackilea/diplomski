barPanel.setLayout(new GridLayout(0 , 4));
     JPanel newPanel=new JPanel();

     healthBar = new JProgressBar (0,100);
     healthLabel = new JLabel ("Health: ");
      newPanel.add(healthBar);
      healthBar.setPreferredSize( new Dimension (width, height));
     //healthBar.setMaximumSize(new Dimension(width,height));
     //healthBar.setMinimumSize(new Dimension(width, height));

     barPanel.add(healthLabel);
     healthLabel.setForeground(Color.white);

 barPanel.add(newPanel);