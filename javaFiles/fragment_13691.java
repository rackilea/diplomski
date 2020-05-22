// Create Chart
Chart_XY chart = new ChartBuilder_XY().width(800).height(600).xAxisTitle("X").yAxisTitle("Y").build();

// Customize Chart
chart.getStyler().setLegendPosition(LegendPosition.InsideNE);

// Series
chart.addSeries("a", new double[] { 0, 3, 5, 7, 9 }, new double[] { -3, 5, 9, 6, 5 }).setMarker(SeriesMarkers.NONE);
chart.addSeries("b", new double[] { 0, 2, 4, 6, 9 }, new double[] { -1, 6, 4, 0, 4 }).setMarker(SeriesMarkers.NONE);
chart.addSeries("c", new double[] { 0, 1, 3, 8, 9 }, new double[] { -2, -1, 1, 0, 1 }).setMarker(SeriesMarkers.NONE);