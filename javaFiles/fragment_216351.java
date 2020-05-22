// Construct panel
    //panel.setPreferredSize(new Dimension(600, 600)); // No need for panel as it will get added to scrollpane
    panel.setLayout(new GridBagLayout());
    panel.setBorder(LineBorder.createBlackLineBorder());


    JScrollPane scrollPane = new JScrollPane(panel,   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setPreferredSize(new Dimension(600, 600));
    // Add panel to frame
    frameConstraints.gridx = 0;
    frameConstraints.gridy = 1;
    frameConstraints.weighty = 1;
    frame.add(scrollPane, frameConstraints); // add acrollpane to frame