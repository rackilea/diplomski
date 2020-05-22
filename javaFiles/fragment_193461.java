JLabel someLabel = new JLabel("something");

...
MigLayout layout = new MigLayout("wrap 2", "[right][grow]");
guiPanel.setLayout(layout);

guiPanel.add(someLabel,"grow");