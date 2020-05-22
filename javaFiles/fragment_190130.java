try {
    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
    ChartUtilities.writeChartAsPNG(response, chart, 600, 400, info);
} catch (Exception e) {
    System.out.println(e);
}