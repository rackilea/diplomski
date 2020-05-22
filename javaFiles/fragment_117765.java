// ScrollPane in a SplitPane
var scrollPane = new JScrollPane();
var splitPane = new JSplitPane();
splitPane.setLeftComponent(scrollPane);
splitPane.setRightComponent(new JLabel("dummy"));

// ScrollPane contains a Gridbag layout panel
var gridBagLayout = new GridBagLayout();
var panel = new JPanel(gridBagLayout);
scrollPane.setViewportView(panel);

// add horizontal filling Buttons
var gbc = new GridBagConstraints(
    0, RELATIVE, 1, 1, 1.0, 0.0, 
    CENTER, HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0);
panel.add(new JButton("first"), gbc);
panel.add(new JButton("second"), gbc);

JOptionPane.showMessageDialog(null, splitPane);