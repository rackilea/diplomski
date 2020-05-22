public class XYIntervalBarChart extends ApplicationFrame{

private static final String NODATA_SERIES   = "NODATA";
private static final String STANDBY_SERIES  = "STANDBY";
private static final String HEATING_SERIES  = "HEATING";
private static final String HOLDING_SERIES  = "HOLDING";
private static final String COOLING_SERIES  = "COOLING";
private static final String LOWERING_SERIES = "LOWERING";

ArrayList<EventStatus> testData = null;
String[] catArray;

JFreeChart chart;
DateAxis dateAxis;

Date chartStartDate;
Date chartEndDate;

public XYIntervalBarChart(String title) {
    super(title);
    // set up some test data
    initData();

    chartStartDate  = new Date(1477461600000L);
    chartEndDate = new Date(1477497600000L);
    chart = createIntervalStackedChart();
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new Dimension(600, 450));
    setContentPane(chartPanel);
}

private JFreeChart createIntervalStackedChart() {
    XYIntervalSeriesCollection dataset = createXYIntervalDataset();
    XYBarRenderer xyRend = new XYBarRenderer();
    xyRend.setShadowVisible(false);
    xyRend.setUseYInterval(true);
    xyRend.setBarPainter(new StandardXYBarPainter());
    xyRend.setSeriesPaint(0, Color.BLACK);
    xyRend.setSeriesPaint(1, Color.DARK_GRAY);
    xyRend.setSeriesPaint(2, Color.RED);
    xyRend.setSeriesPaint(3, Color.YELLOW);
    xyRend.setSeriesPaint(4, Color.CYAN);
    xyRend.setSeriesPaint(5, Color.GREEN);

    dateAxis = new DateAxis();
    dateAxis.setVerticalTickLabels(true);
    dateAxis.setDateFormatOverride(new SimpleDateFormat("dd.MM.yy HH:mm"));
    XYPlot plot = new XYPlot(dataset, new SymbolAxis("", catArray), dateAxis, xyRend);
    plot.setOrientation(PlotOrientation.HORIZONTAL);
    plot.setBackgroundPaint(Color.LIGHT_GRAY);
    return new JFreeChart(plot);
}

private XYIntervalSeriesCollection createXYIntervalDataset() {
    XYIntervalSeriesCollection dataset = new XYIntervalSeriesCollection();

    int statesCount = 6;
    String[] states = new String[] {NODATA_SERIES, STANDBY_SERIES, HEATING_SERIES, HOLDING_SERIES, COOLING_SERIES, LOWERING_SERIES};

    XYIntervalSeries[] series = new XYIntervalSeries[statesCount];
    for (int i = 0; i < statesCount; i++) {
        series[i] = new XYIntervalSeries(states[i]);
        dataset.addSeries(series[i]);
    }

    for (int i = 0; i < testData.size(); i++) {
        EventStatus es = testData.get(i);
        int machNo = es.getPlanningNo();
        int state = es.getStatus();
        long eventStart = es.getTime();
        long eventEnd = 0;
        if (testData.indexOf(es) == testData.size() - 1) {
            eventEnd = chartEndDate.getTime();
        }
        else {
            EventStatus nextEs = testData.get(i + 1);
            if (nextEs.getTime() > eventStart) {
                eventEnd = nextEs.getTime();
            }
            else {
                eventEnd = chartEndDate.getTime();
            }
        }

        long duration = TimeUnit.MILLISECONDS.convert(eventEnd - eventStart, TimeUnit.MILLISECONDS);
        series[state].add(machNo, machNo - 0.2, machNo + 0.2, eventStart, eventStart, eventStart + duration);
    }

    return dataset;
}

private void initData() {
    testData = new ArrayList<EventStatus>();
    testData.add(new EventStatus("Mach-1", 1477468500000L, 1, 0)); // 26.10.16 09:55  standby
    testData.add(new EventStatus("Mach-1", 1477472100000L, 2, 0)); // 26.10.16 10:55  heating
    testData.add(new EventStatus("Mach-1", 1477474200000L, 5, 0)); // 26.10.16 11:30  lowering
    testData.add(new EventStatus("Mach-1", 1477476000000L, 3, 0)); // 26.10.16 12:00  holding
    testData.add(new EventStatus("Mach-1", 1477479600000L, 4, 0)); // 26.10.16 13:00  cooling
    testData.add(new EventStatus("Mach-1", 1477486800000L, 1, 0)); // 26.10.16 15:00  standby

    testData.add(new EventStatus("Mach-2", 1477465200000L, 3, 1)); // 26.10.16 09:00  holding
    testData.add(new EventStatus("Mach-2", 1477472400000L, 2, 1)); // 26.10.16 11:00  heating
    testData.add(new EventStatus("Mach-2", 1477474200000L, 5, 1)); // 26.10.16 11:30  lowering
    testData.add(new EventStatus("Mach-2", 1477476000000L, 2, 1)); // 26.10.16 12:00  heating
    testData.add(new EventStatus("Mach-2", 1477479600000L, 3, 1)); // 26.10.16 13:00  holding
    testData.add(new EventStatus("Mach-2", 1477486800000L, 4, 1)); // 26.10.16 15:00  cooling


    ArrayList<String> list = new ArrayList<>();
    for (EventStatus eventStatus : testData) {
        if (list.contains(eventStatus.getName()))
            continue;
        else
            list.add(eventStatus.getName());
    }

    catArray = new String[list.size()];
    catArray = list.toArray(catArray);
}

public static void main(String[] args) {
    XYIntervalBarChart demo = new XYIntervalBarChart("XYIntervalBarChart");
    demo.pack();
    RefineryUtilities.centerFrameOnScreen(demo);
    demo.setVisible(true);

}}