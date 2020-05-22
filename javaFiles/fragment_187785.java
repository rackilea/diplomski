JButton myBtn = new JButton(); //Theinitial button
JPanel mainPanel = new JPanel(new GridBagLayout()); //main panel
JPanel inheritedPanel = new JPanel(new BorderLayout())//borderlayout to fill the entire panel.
inheritedPanel.add(myBtn,BorderLayout.CENTER);
mainPanel.add(inheritedPanel, myConstraints);

JButton replacementBtn = new JButton;
inheritedPanel.remove(myBtn);
inheritedPanel.add(replacementBtn);
inheritedPanel.repaint();
inheritedPanel.revalidate();