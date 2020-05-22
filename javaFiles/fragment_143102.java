// Create tabbed pane and add tabs.
JTabbedPane tabbedPane = ...

// Create bespoke component for rendering the tab.
JLabel lbl = new JLabel("Hello, World");
Icon icon = new ImageIcon(getClass().getResource("/foo/bar/hello.jpg"));
lbl.setIcon(icon);

// Add some spacing between text and icon, and position text to the RHS.
lbl.setIconTextGap(5);
lbl.setHorizontalTextPosition(SwingConstants.RIGHT);

// Assign bespoke tab component for first tab.
tabbedPane.setTabComponentAt(0, lbl);