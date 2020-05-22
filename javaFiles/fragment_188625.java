JPanel outerPanel = new JPanel(new BorderLayout());
JPanel innerPanel= new JPanel(new BorderLayout());

innerPanel.add(buttonPanel,BorderLayout.NORTH);
innerPanel.add(logScrollPane, BorderLayout.CENTER);
innerPanel.add(about, BorderLayout.SOUTH);

outerPanel.add(imageLabel, BorderLayout.NORTH);
outerPanel.add(innerPanel,BorderLayout.CENTER);