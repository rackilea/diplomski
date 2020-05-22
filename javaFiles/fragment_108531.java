public class ChartCustomizer implements JRChartCustomizer {

    @Override
    public void customize(JFreeChart jfchart, JRChart jrchart) {
        CategoryPlot plot = (CategoryPlot) jfchart.getPlot();
        CategoryAxis range = plot.getDomainAxis();
        //Don't show the range axis
        range.setVisible(false);

        //Lets remove the 0, in your case you can do a customizer to remove the 2 on the other chart
        NumberAxis rangeAxis = new NumberAxis() {

            private static final long serialVersionUID = 3744076016723532336L;

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            public List refreshTicks(Graphics2D g2, AxisState state, Rectangle2D dataArea, RectangleEdge edge) {

                List allTicks = super.refreshTicks(g2, state, dataArea, edge);
                NumberTick t0 = new NumberTick(TickType.MAJOR, 0, "", TextAnchor.CENTER_RIGHT, TextAnchor.CENTER_RIGHT, 0);
                allTicks.set(0, t0);
                return allTicks;
            }
        };

        //Set range and paint, since we replace the rangeAxis
        rangeAxis.setRange(0, 2);
        rangeAxis.setTickLabelPaint(Color.RED); 
        plot.setRangeAxis(rangeAxis);

    }

    public static void main(String[] args) throws Exception {
        JasperReport report = JasperCompileManager.compileReport("ChartTest.jrxml");

        JRCsvDataSource ds = new JRCsvDataSource(new File("ChartData.csv"));
        ds.setNumberFormat(NumberFormat.getInstance(Locale.US)); //. as decimal separator
        ds.setFieldDelimiter(';');
        ds.setUseFirstRowAsHeader(true);

        Map<String, Object> paramMap = new HashMap<String, Object>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, paramMap, ds);
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("ChartTest.pdf"));
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        configuration.setCreatingBatchModeBookmarks(true);
        configuration.setMetadataAuthor("Petter");
        exporter.setConfiguration(configuration);
        exporter.exportReport();
    }
}