JFrame frame = new JFrame();
JPanel panel = new JPanel();
panel.setLayout(new GridBagLayout());
GridBagConstraints gc = new GridBagConstraints();

gc.gridx=0;
gc.gridy=0;
gc.fill = GridBagConstraints.HORIZONTAL;
gc.weightx = 1.0;
gc.gridwidth = 2;
JLabel title = new JLabel("TITLE");
title.setBackground(Color.RED);
title.setOpaque(true);
title.setHorizontalAlignment(SwingConstants.CENTER);
panel.add(title, gc);

gc.gridx=0;
gc.gridy=1;
gc.weightx = 0.5;
gc.gridwidth = 1;        
JLabel col1 = new JLabel("COLUMN 1 TITLE");
col1.setBackground(Color.YELLOW);
col1.setOpaque(true);
col1.setHorizontalAlignment(SwingConstants.CENTER);
panel.add(col1, gc);

gc.gridx=1;
gc.gridy=1;        
JLabel col2 = new JLabel("COLUMN 2 TITLE");
col2.setBackground(Color.GREEN);
col2.setOpaque(true);
col2.setHorizontalAlignment(SwingConstants.CENTER);
panel.add(col2, gc);

gc.fill = GridBagConstraints.BOTH;
gc.gridx=0;
gc.gridy=2;
gc.weighty = 1.0;
gc.gridwidth = 1;        
JLabel info1 = new JLabel("Info 1 Text");
info1.setBackground(Color.CYAN);
info1.setOpaque(true);
info1.setHorizontalAlignment(SwingConstants.CENTER);
panel.add(info1, gc);

gc.gridx=1;
gc.gridy=2;
JLabel info2 = new JLabel("Info 2 Text");
info2.setBackground(Color.MAGENTA);
info2.setOpaque(true);
info2.setHorizontalAlignment(SwingConstants.CENTER);
panel.add(info2, gc);

frame.add(panel);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);