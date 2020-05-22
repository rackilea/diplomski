JPanel contentPanel = new JPanel();
GridBagLayout gbl_contentPanel = new GridBagLayout();
// This tells the layout that first row should take all available space (there is only one row)
gbl_contentPanel.rowWeights = new double[]{1.0};
// This tells the layout that second column should be 3 times bigger than first column (3 is 3 times bigger than 1)
gbl_contentPanel.columnWeights = new double[]{1.0, 3.0};
contentPanel.setLayout(gbl_contentPanel);