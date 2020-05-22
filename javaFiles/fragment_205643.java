public String createLineChart() throws IOException {
        System.out.println("Line chart");
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(14, "Line", "2008");
        dataset.addValue(18, "Line", "2009");
        dataset.addValue(22, "Line", "2010");

        dataset.addValue(13, "Line2", "2008");
        dataset.addValue(13, "Line2", "2009");
        dataset.addValue(13, "Line2", "2010");
        final JFreeChart chart = ChartFactory.createLineChart(
                "", // chart title
                "", // domain axis label
                "", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                false, // include legend
                false, // tooltips
                false // urls
        );

        chart.setBackgroundPaint(Color.WHITE);
        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeZeroBaselinePaint(Color.RED);
        plot.setOutlineVisible(false);
        plot.setRangeGridlinePaint(Color.white);
        plot.setDomainGridlinePaint(Color.BLUE);

        final CategoryAxis categoryAxis = (CategoryAxis) plot.getDomainAxis();
        categoryAxis.setAxisLineVisible(false);
        categoryAxis.setTickMarksVisible(false);
        categoryAxis.setMaximumCategoryLabelLines(2);

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setVisible(false);
        rangeAxis.setLabelPaint(Color.BLUE);
        rangeAxis.setRange(13, 23);
        rangeAxis.setTickUnit(new NumberTickUnit(20));

        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);
        renderer.setBaseShapesFilled(true);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesItemLabelsVisible(1, Boolean.TRUE);
        Shape circle = new Ellipse2D.Double(-3, -3, 6, 6);
        renderer.setSeriesShape(0, circle);
        renderer.setSeriesShape(1, null);
        renderer.setBaseItemLabelGenerator(new CustomLabelGenerator());
//        MyGenerator generator=new MyGenerator();
//        renderer.setSeriesItemLabelGenerator(1, generator);
        renderer.setBaseItemLabelsVisible(true);
        plot.getRenderer().setSeriesPaint(0, Color.decode("#0066CC"));
        plot.getRenderer().setSeriesPaint(1, Color.WHITE);

//        ValueAxis range = plot.getRangeAxis();
//        range.setUpperMargin(0.20);
        try {
            ChartUtilities.saveChartAsPNG(new File("/media/root/668ea9a3-d26c-4896-a2f0-756dfb532756/jfreeLinechart.png"), chart, 400, 200);
            System.out.println("=====chart=====");
        } catch (IOException e) {
            System.out.println("Line chart :" + e);
        }
        xyLineChart();
        return "success";
    }

    static class CustomLabelGenerator extends AbstractCategoryItemLabelGenerator implements CategoryItemLabelGenerator {

            public CustomLabelGenerator() {
                super("", NumberFormat.getCurrencyInstance());
            }

            public String generateLabel(CategoryDataset dataset, int series, int category) {

                String result = null;
                if (series == 1) {
                    series = 0;
                    Number value = dataset.getValue(series, category);
                    result = value.toString();
                    System.out.println("===========result===============" + series + "====category======" + category);
                }
                return result;
            }

            public String generateRowLabel(CategoryDataset arg0, int arg1) {
                return null;
            }

            public String generateColumnLabel(CategoryDataset arg0, int arg1) {
                return null;
            }
        }