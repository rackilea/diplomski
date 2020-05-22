// Specify the colors
UIDefaults uiDef = new UIDefaults();
uiDef.put("Panel.background", Color.BLUE);

// Use the colors on a specific component
JPanel panel = new JPanel();
panel.putClientProperty("Nimbus.Overrides", uiDef);
SwingUtilities.updateComponentTreeUI(panel);