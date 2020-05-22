lineEntries = new ArrayList<Entry>();
    lineEntries.add(new Entry(0, 10));
    lineEntries.add(new Entry(1, 11));
    lineEntries.add(new Entry(2, 12));
    lineEntries.add(new Entry(3, 14));
    lineEntries.add(new Entry(4, 18));
    lineEntries.add(new Entry(5, 31));

    lineDataSet = new LineDataSet(lineEntries, "Line");
    lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
    lineDataSet.setHighlightEnabled(true);
    lineDataSet.setLineWidth(3);
    lineDataSet.setColor(getColor("defaultBlue"));
    lineDataSet.setCircleColor(getColor("defaultOrange"));
    lineDataSet.setCircleRadius(6);
    lineDataSet.setCircleHoleRadius(3);
    lineDataSet.setDrawHighlightIndicators(true);
    lineDataSet.setHighLightColor(Color.RED);
    lineDataSet.setValueTextSize(defaultValueTextSize);
    lineDataSet.setValueTextColor(getColor("primaryDark"));

    LineData lineData = new LineData(lineDataSet);
    lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTH_SIDED);
    lineChart.animateY(1000);
    lineChart.setData(lineData);