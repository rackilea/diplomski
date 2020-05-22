cp.setLayout(new GridBagLayout());
    GridBagConstraints layoutConstraints = new GridBagConstraints();
    layoutConstraints.fill = GridBagConstraints.BOTH;
    layoutConstraints.gridx = 0;
    layoutConstraints.gridy = 0;
    layoutConstraints.weighty = 1;
    layoutConstraints.weightx = 0.8;
    house.setMinimumSize(new Dimension(1500, 1080));
    cp.add(house, layoutConstraints);

    GridBagConstraints layoutConstraints2 = new GridBagConstraints();
    layoutConstraints2.fill = GridBagConstraints.BOTH;
    layoutConstraints2.weighty = 1;
    layoutConstraints2.weightx = 0.2;
    layoutConstraints2.gridx = 1;
    layoutConstraints2.gridy = 0;
    cp.add(dataPanel, layoutConstraints2);

    dataPanel.setVisible(true);
    cp.revalidate();