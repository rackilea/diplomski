JasperDesign report = new JasperDesign();
report.setName("chart");

JRDesignBand summary = new JRDesignBand();
summary.setHeight(300);
report.setSummary(summary);

JRDesignComponentElement chartElement = new JRDesignComponentElement();
chartElement.setX(0);
chartElement.setY(0);
chartElement.setWidth(500);
chartElement.setHeight(300);
chartElement.setComponentKey(HighchartsConstants.DEFAULT_COMPONENT_KEY);

StandardChartComponent chart = new StandardChartComponent();
chart.setType(ChartType.COLUMN_CHART);

StandardChartSetting defaultSetting = new StandardChartSetting();
defaultSetting.setName(HighchartsConstants.SETTING_NAME_DEFAULT);
//set a static String property
defaultSetting.addChartProperty(new StandardChartProperty("title.text", 
        "My chart title", null));
//set an expression based boolean property
defaultSetting.addChartProperty(new StandardChartProperty("plotOptions.series.dataLabels.enabled", 
        null, new JRDesignExpression("true")));
chart.addChartSetting(defaultSetting);

DesignMultiAxisData data = new DesignMultiAxisData();
DesignMultiAxisDataset dataset = new DesignMultiAxisDataset();
//this actually means feeding data to the chart on each record
dataset.setIncrementType(IncrementTypeEnum.NONE);
data.setDataset(dataset);

DesignDataAxis rowAxis = new DesignDataAxis();
rowAxis.setAxis(Axis.ROWS);
DesignDataAxisLevel level = new DesignDataAxisLevel();
level.setName("rows");
level.setLabelExpression(new JRDesignExpression("\"Rows\""));
DesignDataLevelBucket levelBucket = new DesignDataLevelBucket();
//expression that produces category values
levelBucket.setExpression(new JRDesignExpression("\"Row \" + $V{REPORT_COUNT}"));
level.setBucket(levelBucket);
rowAxis.addLevel(level);
data.addDataAxis(rowAxis);

DesignDataMeasure measure = new DesignDataMeasure();
measure.setName("measure");
measure.setLabelExpression(new JRDesignExpression("\"Data\""));
measure.setCalculation(CalculationEnum.NOTHING);
measure.setValueClassName("java.lang.Integer");
//expression that produces series values
measure.setValueExpression(new JRDesignExpression("$V{REPORT_COUNT}"));
data.addMeasure(measure);

chart.setMultiAxisData(data);

chartElement.setComponent(chart);
summary.addElement(chartElement);