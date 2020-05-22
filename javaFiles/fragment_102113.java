JLabel character = new JLabel(...);
character.setSize( character.getPreferredSize() );

JLabel background = new JLabel(...);
background.add( character );

frame.add( background );