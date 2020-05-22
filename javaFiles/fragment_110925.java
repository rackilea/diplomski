private static XYDataset createDataset() throws ParseException {
  SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

  String[][] allDate = new String[][] {
      {"2012/03/25", "2012/03/29", "2012/03/28", "2012/03/27", "2012/03/27", "2012/03/27"},
      {"2012/04/01", "2012/04/02", "2012/04/06", "2012/04/06", "2012/04/06", "2012/04/06"},
      {"2012/04/11", "2012/04/12", "2012/04/08", "2012/04/10", "2012/04/10", "2012/04/10"},
      {"2012/04/15", "2012/04/14", "2012/04/15", "2012/04/18", "2012/04/19", "2012/04/19"},
      {"2012/05/01", "2012/05/02", "2012/05/08", "2012/05/04", "2012/05/04", "2012/05/04"},
      {"2012/05/12", "2012/05/12", "2012/05/18", "2012/05/14", "2012/05/14", "2012/05/14"},
      {"2012/05/22", "2012/05/22", "2012/05/28", "2012/05/28", "2012/05/28", "2012/05/30"},
  };

  String dateY1 = "2012/01/15";
  String dateY2 = "2012/02/15";
  String dateY3 = "2012/03/15";
  String dateY4 = "2012/04/15";
  String dateY5 = "2012/05/15";
  String dateY6 = "2012/06/15";

  XYSeriesCollection dataset = new XYSeriesCollection();
  for (String[] dateOfOneSeries : allDate) {
    XYSeries series = new XYSeries(dateOfOneSeries[0]);

    series.add(df.parse(dateY1).getTime(), df.parse(dateOfOneSeries[0]).getTime());
    series.add(df.parse(dateY2).getTime(), df.parse(dateOfOneSeries[1]).getTime());
    series.add(df.parse(dateY3).getTime(), df.parse(dateOfOneSeries[2]).getTime());
    series.add(df.parse(dateY4).getTime(), df.parse(dateOfOneSeries[3]).getTime());
    series.add(df.parse(dateY5).getTime(), df.parse(dateOfOneSeries[4]).getTime());
    series.add(df.parse(dateY6).getTime(), df.parse(dateOfOneSeries[5]).getTime());
    dataset.addSeries(series);
  }
  return dataset;
}