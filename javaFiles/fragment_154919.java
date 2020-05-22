@Override
  public void actionPerformed(ActionEvent e) {
     // int variable for the tab title
     tabIndex++;
     String title = "Switch " + tabIndex; 

     // I renamed your draw class to conform to Java standards
     DrawPanel tabComponent = new DrawPanel();
     tabbedPane.add(title, tabComponent);
  }