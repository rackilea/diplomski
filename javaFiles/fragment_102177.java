JTextArea ta = new JTextArea(1, 20);
ta.setText("Enter the name of the repo and the name of the owner of that repo to search for open issues.");
ta.setWrapStyleWord(true);
ta.setLineWrap(true);
ta.setBorder(null);
ta.setFont(UIManager.getFont("Label.font"));
ta.setOpaque(false);
ta.setFocusable(false);
ta.setEditable(false);

//JLabel lblTop1 = new JLabel("<html>Enter the name of the repo and the name of the owner of that repo to search for open issues", JLabel.CENTER);
//JLabel lblTop2 = new JLabel("owner of that repo to search for open issues.\n", JLabel.CENTER);
//...
//panTopTop.add(lblTop1);
//panTopBottom.add(lblTop2);
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridwidth = GridBagConstraints.REMAINDER;
panTop.add(ta, gbc);