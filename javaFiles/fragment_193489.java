for (int i = 0; i < columnCount; i++) {
        for (int j = 0; j < rowCount; j++) {
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = i;
            c.gridy = j;
            c.insets = new Insets(2, 2, 2, 2);
            c.weightx = 1;
            c.weighty = 1;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.FIRST_LINE_START;
            NewJPanel p = new NewJPanel(); //A JPanel I created with the same background, width and height of a cell. May work with a normal JPanel as well.
            //p.setVisible(false);
            p.setOpaque(false);
            contentPanel.add(p, c);
        }
    }