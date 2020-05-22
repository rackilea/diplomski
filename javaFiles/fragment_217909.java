JPanel red = new JPanel();
red.setBackground(Color.RED);
red.setPreferredSize( new Dimension(200, 200) );

JPanel outer = new JPanel();
outer.add( red );
add( new JScrollPane(outer) );