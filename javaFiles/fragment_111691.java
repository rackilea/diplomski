contentor3.setLayout (new GridBagLayout());

GridBagConstraints gbc = new GridBagConstraints ();

// next two lines will place the components top-to-bottom, rather than left-to-right
gbc.gridx = 0;
gbc.gridy = GridBagConstraints.RELATIVE;

// add as many buttons as you want in a column
contentor3.add (new JButton ("btn1"), gbc);

contentor.add (contentor3, BorderLayout.EAST);