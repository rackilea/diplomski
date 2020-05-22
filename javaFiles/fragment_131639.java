Container container = frame.getContentPane( );
frame.setLayout( new BoxLayout( container, BoxLayout.Y_AXIS ) );

JPanel panel1 = new JPanel( );
panel1.add( new JButton( "Button #1" ) );
frame.add( panel1 );

JPanel panel2 = new JPanel( );
panel2.add( new JLabel("Label #1") );
frame.add( panel2 );