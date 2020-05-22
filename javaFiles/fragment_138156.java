JFrame frame = new JFrame();
frame.setLayout(new GridBagLayout());

JPanel tilePanel = new JPanel( new GridLayout(0, 1, 5, 5) );
tilePanel.add(new GraphicsTile());
tilePanel.add(new GraphicsTile());

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(tilePanel, new GridBagConstraints());
frame.pack();
frame.setVisible(true);