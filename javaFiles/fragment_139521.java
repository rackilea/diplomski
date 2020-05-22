ExamplePanel panel = new ExamplePanel();
panel.setLayout( null ); // now you set the size/location of any component you add to the panel

JPanel example1 = new JPanel();
example1.setBackground( Color.GREEN );
example1.setBorder( new LineBorder(Color.BLACK) );
example1.setBounds( new Rectangle(....) );

panel.add(example1);