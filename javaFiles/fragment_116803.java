controlPanel.add(new JButton("Play"));
    controlPanel.add(new JButton("Pause"));
    controlPanel.add(new JSpinner());

    JTextArea textArea = new JTextArea(20, 40);

    c.gridx = 0;
    c.gridy = 0;
    c.gridheight = 3;
    c.gridwidth = 3;
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.anchor = GridBagConstraints.NORTHWEST;
    mainPanel.add(new JScrollPane(textArea), c);