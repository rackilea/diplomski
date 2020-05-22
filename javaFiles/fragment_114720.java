ChartPanel p = new ChartPanel(chart);
JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
frame1.add( splitpane , BorderLayout.CENTER );
splitpane.add(p);
splitpane.add(area1);
pane.validate();
frame1.validate();
frame1.repaint();