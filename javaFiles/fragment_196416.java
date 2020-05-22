scroller = new JScrollPane(content);
    c.weightx = 0.5;
    c.weighty = 1.0;
    c.gridx = 0;
    c.gridy = 0;
    panel.add(scroller, c);

    messageInput = new JTextField();
    c.weightx = 0.5;
    c.weighty = 0.0;
    c.gridx = 0;
    c.gridy = 1;
    panel.add(messageInput, c);