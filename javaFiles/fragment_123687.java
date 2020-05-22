JPanel north = new JPanel();
north.add( new JLabel(...) );
north.add( new JTextField(10) );
JPanel gamePanel = new GamePanel();
BackgroundPanel background = new BackgroundPanel(...);
background.add(north, BorderLayout.North);
background.add(gamePanel);
frame.add(background);