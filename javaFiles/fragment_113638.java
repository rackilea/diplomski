// center relative to the button
 dialog.setLocationRelativeTo((Component) e.getSource());

 // center relative to button's parent
 dialog.setLocationRelativeTo(((Component) e.getSource()).getParent());

 // center relative to the tabbedPane
 JTabbedPane tabbed = // walk the parent chain until you reach it
 dialog.setLocationRelativeTo(tabbed);