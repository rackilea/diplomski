KeyPressStats statistics = new KeyPressStats();
HomePanel home = new HomePanel(statistics);
StatsPanel stats = new StatsPanel(statistics);
JTabbedPane tabbed = new JTabbedPane();
tabbed.addTab("Home", home);
tabbed.addTab("Stats", stats);
tabbed.setVisible(true);