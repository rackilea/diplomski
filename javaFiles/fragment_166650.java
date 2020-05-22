JTabbedPane parent = new JTabbedPane();
JPanel child = new JPanel(new BorderLayout());

// Create label with centrally aligned text (default is left).
JLabel label = new JLabel("Hello, World", JLabel.CENTER_ALIGNMENT);

// Add label to center of the child panel.
child.add(label, BorderLayout.CENTER);

// Add child panel as a tab within parent JTabbedPane.
// The child panel will expand to fit the size of the tab.
parent.addTab("My Tab", child);