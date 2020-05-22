// setLayout(new BorderLayout());
    jPan.setLayout(new BorderLayout());

    JPanel northPanel = new JPanel();  // **** to hold buttons

    northPanel.add(sortNameButton);
    northPanel.add(sortTotalButton);
    northPanel.add(searchTextField);
    northPanel.add(statisticsButton);
    northPanel.add(exitButton);

    jPan.add(northPanel, BorderLayout.PAGE_START);
    jPan.add(infoTextArea, BorderLayout.CENTER);