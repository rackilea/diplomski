JPanel panTop = new JPanel(new GridBagLayout());
panTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//JPanel panTopTop = new JPanel();
//panTopTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//JPanel panTopBottom = new JPanel();
//panTopBottom.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

//...

//panTopTop.add(lblTop1);
//panTopBottom.add(lblTop2);
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridwidth = GridBagConstraints.REMAINDER;
panTop.add(lblTop1, gbc);
panTop.add(lblTop2, gbc);
//panTop.add(panTopBottom, BorderLayout.SOUTH);