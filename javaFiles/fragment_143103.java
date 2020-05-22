private void addTab(JTabbedPane tabbedPane, Component tab, String title, Icon icon) {
  tabbedPane.add(tab);

  JLabel lbl = ... // Create bespoke label for rendering tab title.

  tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, lbl);
}