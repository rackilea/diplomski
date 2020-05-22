Dimension size = new Dimension(width, height);
JPanel panel;

add(panel = new JPanel(), BorderLayout.WEST);
panel.setPreferredSize(size); 

add(panel = new JPanel(), BorderLayout.EAST);
panel.setPreferredSize(size); 

add(panel = new JPanel(), BorderLayout.SOUTH);
panel.setPreferredSize(size);