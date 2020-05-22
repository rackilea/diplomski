JPanel panel = new JPanel();
GridBagLayout layout = new GridBagLayout();
layout.columnWidths = new int[] { 0, 0 };
layout.rowHeights = new int[] { 0, 0, 0, 0 };
layout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
layout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
panel.setLayout(layout);

JPanel menuBar = new JPanel();
GridBagConstraints contraints = new GridBagConstraints();
contraints.fill = GridBagConstraints.BOTH;
contraints.gridx = 0;
contraints.gridy = 0;
panel.add(menuBar, contraints);

JPanel panelForLabels = new JPanel();
contraints = new GridBagConstraints();
contraints.fill = GridBagConstraints.BOTH;
contraints.gridx = 0;
contraints.gridy = 1;
panel.add(panelForLabels, contraints);

JPanel bigPanel = new JPanel();
contraints = new GridBagConstraints();
contraints.fill = GridBagConstraints.BOTH;
contraints.gridx = 0;
contraints.gridy = 2;
panel.add(bigPanel, contraints);