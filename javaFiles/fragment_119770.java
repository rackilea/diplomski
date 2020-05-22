GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    this.setLayout(gridbag);

    c.fill = GridBagConstraints.BOTH;

    c.gridwidth = 1;
    c.gridheight = 2;
    c.gridx = 0;
    c.gridy = 0;
    c.weighty = PANEL_HEIGHT;
    gridbag.setConstraints(labelA, c);
    this.add(labelA);

    c.gridx = 1;
    c.gridy = 0;
    gridbag.setConstraints(labelB, c);
    this.add(labelB);

    c.gridx = 2;
    c.gridy = 0;
    c.gridheight = 1;
    c.weighty = TOPROW_HEIGHT;
    gridbag.setConstraints(labelC, c);
    this.add(labelC);


    c.gridx = 3;
    c.gridy = 0;
    c.gridheight = 2;
    c.gridwidth = GridBagConstraints.REMAINDER;
    c.weighty = PANEL_HEIGHT;
    gridbag.setConstraints(labelD, c);
    this.add(labelD);

    c.gridx = 2;
    c.gridy = 1;
    c.fill = GridBagConstraints.VERTICAL;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.weighty = BOTROW_HEIGHT;
    gridbag.setConstraints(labelE, c);
    this.add(labelE);

    this.validate();