panel = new JPanel(new BorderLayout());
panel.setPreferredSize(new Dimension(130, 300));
JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
buttonPanel.add(button);
panel.add(buttonPanel, BorderLayout.SOUTH);
JPanel labelPanel = newJPanel(new FlowLayout(FlowLayout.LEFT));
labelPanel.add(jLabel1);
labelPanel.add(jLabel2);
panel.add(labelPanel, BorderLayout.CENTER));