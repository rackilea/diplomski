JPanel panel = new JPanel(new MigLayout());
panel.add(menuBarPanel, "wrap");
panel.add(jTreePanel, "dock west");
panel.add(headerPanel, "wrap");
panel.add(descriptionPanel, "wrap");
panel.add(tabbedPane, "wrap");