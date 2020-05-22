ArrayList<Entry> lineEntries = new ArrayList<Entry>();
    lineEntries.add(new Entry(0, 6));
    lineEntries.add(new Entry(1, 9));
    lineEntries.add(new Entry(2, 4));
    lineEntries.add(new Entry(3, 8));
    lineEntries.add(new Entry(4, 12));
    lineEntries.add(new Entry(5, 10));

    LineDataSet lineDataSet1 = new LineDataSet(lineEntries, "Line1");
    lineDataSet1.setAxisDependency(YAxis.AxisDependency.LEFT);
    lineDataSet1.setColors(getColor("defaultGreen"));
    lineDataSet1.setLineWidth(3);
    lineDataSet1.setHighlightEnabled(true);
    lineDataSet1.setCircleColor(getColor("defaultOrange"));
    lineDataSet1.setCircleRadius(6);
    lineDataSet1.setCircleHoleRadius(3);
    lineDataSet1.setDrawHighlightIndicators(true);
    lineDataSet1.setHighLightColor(Color.RED);
    lineDataSet1.setValueTextSize(defaultValueTextSize);
    lineDataSet1.setValueTextColor(getColor("primaryDark"));
    lineDataSet1.setMode(LineDataSet.Mode.CUBIC_BEZIER);

    ArrayList<Entry> lineEntries2 = new ArrayList<Entry>();
    lineEntries2.add(new Entry(0, 8));
    lineEntries2.add(new Entry(1, 11));
    lineEntries2.add(new Entry(2, 6));
    lineEntries2.add(new Entry(3, 10));
    lineEntries2.add(new Entry(4, 14));
    lineEntries2.add(new Entry(5, 12));

    LineDataSet lineDataSet2 = new LineDataSet(lineEntries2, "Line2");
    lineDataSet2.setAxisDependency(YAxis.AxisDependency.LEFT);
    lineDataSet2.setColors(getColor("defaultOrange"));
    lineDataSet2.setLineWidth(3);
    lineDataSet2.setHighlightEnabled(true);
    lineDataSet2.setCircleColor(getColor("defaultGreen"));
    lineDataSet2.setCircleRadius(6);
    lineDataSet2.setCircleHoleRadius(3);
    lineDataSet2.setDrawHighlightIndicators(true);
    lineDataSet2.setHighLightColor(Color.RED);
    lineDataSet2.setValueTextSize(defaultValueTextSize);
    lineDataSet2.setValueTextColor(getColor("primaryDark"));
    lineDataSet2.enableDashedLine(8,16,4);
    lineDataSet2.setMode(LineDataSet.Mode.CUBIC_BEZIER);

    ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
    dataSets.add(lineDataSet1);
    dataSets.add(lineDataSet2);

    LineData data = new LineData(dataSets);

    lineChart.setData(data);
    lineChart.animateY(1000);
    lineChart.getDescription().setText("Line Comparison Chart");

    Legend legend = lineChart.getLegend();
    legend.setStackSpace(5);
    legend.setTextColor(Color.BLACK);

    // xAxis customization
    XAxis xAxis = lineChart.getXAxis();
    xAxis.setGranularity(1f);
    xAxis.setGranularityEnabled(true);
    xAxis.setCenterAxisLabels(false);
    xAxis.setDrawGridLines(true);
    xAxis.setTextColor(Color.BLACK);
    xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);

    YAxis leftAxis = lineChart.getAxisLeft();
    leftAxis.setTextColor(Color.BLACK);
    YAxis rightAxis = lineChart.getAxisRight();
    rightAxis.setTextColor(Color.BLACK);