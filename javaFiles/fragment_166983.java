c.gridx = 0;
c.gridy = 0;
c.fill = GridBagConstraints.BOTH; // make the component fill its display area entirely
c.ipady = 150; //height
c.anchor = GridBagConstraints.FIRST_LINE_START; // component start from the left top corner
this.getContentPane().add(this.scrollPane, c);