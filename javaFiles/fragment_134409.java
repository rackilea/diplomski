JLabel name_label = new JLabel("Name on Order");
name.addActionListener(this);
JPanel verticalNestedPanel = new JPanel(new BorderLayout());
verticalNestedPanel.add(name_label, BorderLayout.PAGE_START);
verticalNestedPanel.add(name, BorderLayout.PAGE_END);
panel5.add(verticalNestedPanel);