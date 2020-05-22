UIDefaults defaults = new UIDefaults();
defaults.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.GREEN));
defaults.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.GREEN));

progressBar.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
progressBar.putClientProperty("Nimbus.Overrides", defaults);