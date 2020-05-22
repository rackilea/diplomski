ImageIcon i2 = new ImageIcon(resource);  
JLabel label = new JLabel(i2);
label.setPreferredSize(new Dimension(1000,1000));
label.setVisible(true);
pane.add(label);
...
pane.setLayout(new GridBagLayout());