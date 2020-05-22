jScrollPane1 = new JScrollPane();
TableModel jTable1Model = new DefaultTableModel(...); 
JTable jTable1 = new JHorizontalFriendlyTable();
jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
jScrollPane1.setViewPortView(jTable1);
jTable1.setModel(jTable1Model);
jTable1.setPreferredSize(new java.awt.Dimension(1051,518));
jTable1.setPreferredScrollableViewPortSize(new java.awt.Dimension(1000,528));
jTable1.getSize(new java.awt.Dimension(1051, 528));

if (jTable1.getPreferredScrollableViewPortSize().getWidth() > 
  ((JViewPort) jTable1.getParent()).getPreferredSize().getWidth())
  {
  jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
  jTable1.doLayout();
}

jTable1.setDragEnabled(false);
jTable1.setColumnSelectionAllowed(false);
jTable1.getTableHeader().setReorderingAllowed(false);