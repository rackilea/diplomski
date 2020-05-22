//Simple case: creates a split pane with three
//compartments
JXMultiSplitPane sp = new JXMultiSplitPane();
sp.setModel(new DefaultSplitPaneModel());
sp.add(left, DefaultSplitPaneModel.LEFT);
sp.add(top, DefaultSplitPaneModel.TOP);
sp.add(bottom, DefaultSplitPaneModel.BOTTOM);