// 80% with a minimum of 600 logical pixel:
MigLayout layout = new MigLayout("wrap 2, debug",
        "[600:pref, fill, grow][20%]");
JComponent comp = new JPanel(layout);
comp.add(pane, "spany");
comp.add(new JLabel("just something"));