JPanel panel2 = new JPanel(new BorderLayout());
// panel2 = new JPanel(new GridLayout(1, 2 ));//why this it will overwrite the above layout
panel2.add(scrol1,BorderLayout.WEST);
panel2.add(scrol2,BorderLayout.EAST);
add(panel2);  
revalidate();
repaint();