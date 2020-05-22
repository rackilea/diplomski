JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
tabbedPane.setBounds(10, 211, 464, 240);
getContentPane().add(tabbedPane);

JPanel panel = new JPanel();
tabbedPane.addTab("New tab", null, panel, null);
panel.setLayout(null);

JLabel lblNewLabel_1 = new JLabel("New label");
lblNewLabel_1.setBounds(43, 35, 46, 14);
panel.add(lblNewLabel_1);

JPanel panel_1 = new JPanel();
tabbedPane.addTab("New tab", null, panel_1, null);
panel_1.setLayout(null);

JLabel lblNewLabel = new JLabel("New label");
lblNewLabel.setBounds(50, 149, 46, 14);
panel_1.add(lblNewLabel);