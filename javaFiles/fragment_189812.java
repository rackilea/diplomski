JPanel mainPanel = new JPanel(new GridBagLayout());
GridBagConstraints c = new GridBagConstraints();
c.gridx = 1;
c.gridy = 0;
c.weightx = 0.0;
c.anchor = GridBagConstraints.FIRST_LINE_START;

mainPanel.add(titleLabel,  c);
c.gridy = 1;
mainPanel.add(subtitleLabel, c);

JPanel colorPanel = new JPanel();
colorPanel.setBackground(Color.red);
colorPanel.setOpaque(true);

JPanel colorPanel2 = new JPanel();
colorPanel2.setBackground(Color.gray);
colorPanel2.setOpaque(true);

c.weighty = 1.0;
c.gridy = 0;
c.gridx = 0;
c.weightx = 1.0;
c.gridheight = 2;
c.fill = GridBagConstraints.BOTH;
mainPanel.add(colorPanel, c);
c.gridx = 2;
mainPanel.add(colorPanel2, c);

add(mainPanel);