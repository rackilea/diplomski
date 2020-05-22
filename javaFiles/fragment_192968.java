for (ReportRow row: rows) {
    List<String> dimensions = row.getDimensions();
    List<DateRangeValues> metrics = row.getMetrics();
    for (int i = 0; i < dimensionHeaders.size() && i < dimensions.size(); i++) {
      System.out.println(dimensionHeaders.get(i) + ": " + dimensions.get(i));
    }

    for (int j = 0; j < metrics.size(); j++) {
      System.out.print("Date Range (" + j + "): ");
      DateRangeValues values = metrics.get(j);
      for (int k = 0; k < values.getValues().size() && k < metricHeaders.size(); k++) {
        System.out.println(metricHeaders.get(k).getName() + ": " + values.getValues().get(k));
      }
    }
  }