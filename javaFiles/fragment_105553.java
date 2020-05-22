GridBagLayout gridBagLayout = new GridBagLayout();
vehicleMain.setLayout(gridBagLayout);

GridBagConstraints gc = new GridBagConstraints();
gc.fill = GridBagConstraints.BOTH;// set VERTICAL/HORIZONTAL as per need
gc.weightx=1; // 100% horizontally
gc.weighty=1; // 100% vertically

gc.gridx = 0; // first column
gc.gridy = 0; // first row
vehicleMain.add(pnlLorry, gc);// notice second parameter

gc.gridx = 0; // first column 
gc.gridy = 1; // second row
vehicleMain.add(pnlCars, gc);// notice second parameter