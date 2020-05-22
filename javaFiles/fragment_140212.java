JCheckBox checkbox = new JCheckBox("Enable Spinach Study");

JButton applyButton = new JBUtton("Apply");
JButton refreshButton = new JBUtton("Refresh");
JButton cancelButton = new JBUtton("Cancel");

JComponent buttonPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
buttonPane.add(applyButton);
buttonPane.add(refreshButton);
buttonPane.add(cancelButton);

JPanel bottomPanel = new JPanel(new BorderLayout());
bottomPanel.add(checkbox, BorderLayout.PAGE_START);
bottomPanel.add(buttonPane, BorderLayout.PAGE_END);