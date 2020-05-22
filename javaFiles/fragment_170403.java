try {

    OutputStream out = new FileOutputStream(chartName);
    ChartUtilities.writeChartAsPNG(out,
            aJFreeChart,
            aChartPanel.getWidth(),
            aChartPanel.getHeight());

} catch (IOException ex) {
    logger.error(ex);
}