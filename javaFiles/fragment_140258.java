this.add(new JButton(new AbstractAction("Restore") {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFreeChart chart = chartPanel.getChart();
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.getRangeAxis().setRange(auto);
    }
}), BorderLayout.SOUTH);