JLabel background = new JLabel(....);
background.setLayout( new FlowLayout() );

JLabel foreground = new JLabel(...);
background.add( foreground );

frame.add(background, BorderLayout.CENTER);
frame.pack();
frame.setVisible( true );