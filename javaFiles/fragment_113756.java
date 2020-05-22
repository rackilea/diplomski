JPanel outerPanel = new JPanel(new MigLayout());
JPanel upperPanel = new JPanel();
JPanel lowerLeftPanel = new JPanel();
JPanel lowerRightPanel = new JPanel();

outerPanel.add(upperPanel, "span 2, wrap");
outerPanel.add(lowerLeftPanel);
outerPanel.add(lowerRightPanel);