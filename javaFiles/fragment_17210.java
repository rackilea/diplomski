MultiLineTableCellRenderer r = new MultiLineTableCellRenderer();
UIDefaults d = new UIDefaults();
d.put("TextArea.borderPainter", new Painter() {
  @Override public void paint(Graphics2D g, Object o, int w, int h) {}
});
r.putClientProperty("Nimbus.Overrides", d);
r.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

table.setDefaultRenderer(String.class, r);