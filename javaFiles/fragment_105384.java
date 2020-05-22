JPanel panelProd = new JPanel(new BorderLayout());
tableProd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
tableProd.setModel(modeleDatas);
panelProd.add(labelProd, BorderLayout.NORTH);

JScrollPane scrollTab=new JScrollPane(tableProd);    
panelProd.add(scrollTab, BorderLayout.CENTER);

int oldFill = gbcPage.fill;
double oldWeightX = gbcPage.weightx;
double oldWeightY = gbcPage.weighty;

gbcPage.fill = GridBagConstraints.BOTH;
gbcPage.gridx=2;
gbcPage.gridy=1;
gbcPage.gridwidth=1;
gbcPage.weightx=1;
gbcPage.weighty=1;
cardBD.add(panelProd,gbcPage);

gbc.fill = oldFill;
gbc.weightx = oldWeightX;
gbc.weighty = oldWeightY;