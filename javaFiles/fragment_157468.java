private void launchFrame() {
    panel = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    c.fill = GridBagConstraints.HORIZONTAL;  // ** This is also worthwhile **

    textArea = new JTextArea(10, 50);
    scrollPane = new JScrollPane(textArea);
    c.gridx = 0;
    c.gridy = 0;
    c.gridheight = 3;
    panel.add(scrollPane, c);

    btnSend = new JButton("Send");
    c.gridx = 1;
    c.gridy = 0;
    c.gridheight = 1;  // ********* ADD THIS *********
    c.anchor = GridBagConstraints.NORTH;
    panel.add(btnSend, c);

    btnQuit = new JButton("Quit");
    c.gridx = 1;
    c.gridy = 1;
    c.anchor = GridBagConstraints.NORTH;
    panel.add(btnQuit, c);

}