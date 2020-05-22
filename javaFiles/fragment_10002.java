JButton button1 = new JButton("1");
JButton button2 = new JButton("2");
JLabel background = new JLabel( new ImageIcon(...) );
background.setLayout( new GridBagLayout() );
background.add(button1, constraint...);
background.add(button2, constraint...);
frame.add(background);