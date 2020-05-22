public NewJFrame() {
    initComponents();
    ChartPanel cp = d.buildDialPlot(minimumValue, maximumValue, majorTickGap);
    this.add(cp);
    this.pack();
    this.setLocationRelativeTo(null);
}