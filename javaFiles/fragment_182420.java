public void actionPerformed(ActionEvent e){
  JTable oldTable = table;

  // your stuff, loading the table from file

  thePanelHoldingYourTable.remove(oldTable);
  thePanelHoldingYourTable.add(table);
  // if there are other components in that panel, make sure, your table is in the right spot
  // maybe refresh your layout by using invalidate()
}