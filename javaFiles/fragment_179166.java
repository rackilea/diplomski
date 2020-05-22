MigLayout layout = new MigLayout("wrap 1", "[grow]");
mcvePanel.setLayout(layout);

mcvePanel.add(tf1, "growx, width 100:100:, split 3");
mcvePanel.add(tf2, "growx, width 100:100:");
mcvePanel.add(tf3, "growx, width 100:100:");
mcvePanel.add(tf4, "growx, width 100:100:, split 2");
mcvePanel.add(tf5, "growx, width 100:100:");