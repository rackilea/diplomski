ScrollablePanel panel = new ScrollablePanel();
panel.setPreferredSize( new Dimension(30, 30) );
panel.setBorder(BorderFactory.createEtchedBorder(Color.GREEN, Color.MAGENTA));
panel.setBackground(Color.WHITE);
//panel.setLayout(null);
scrollPane.setViewportView(panel);
//scrollPane.setViewportView(this);