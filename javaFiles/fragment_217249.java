if (progressBar.getValue() == 50) {//change color on 50%
   UIDefaults defaults = new UIDefaults();
   defaults.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.RED));
   defaults.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.RED));
   progressBar.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
   progressBar.putClientProperty("Nimbus.Overrides", defaults);                          
}