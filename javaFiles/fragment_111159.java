CardLayout cardLayout = new CardLayout();
JPanel cardPanel = new JPanel(cardLayout);
String oneStr = "One";
String twoStr = "Two";
JLabel oneLabel = new JLabel(oneStr);
JLabel twoLabel = new JLabel(twoStr);
cardPanel.add(oneLabel, oneStr);
cardPanel.add(twoLabel, twoStr);

cardLayout.show(cardPanel, oneStr);//sets "One" visible
cardLayout.show(cardPanel, twoStr);//sets "Two" visible