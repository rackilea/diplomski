XYSeries series1 = new XYSeries("First", true, false);
series1.add(0.1, 25);
series1.add(0.2, 43);
series1.add(0.5, 70);
series1.add(0.64, 94);
series1.add(0.9, 112);

XYSeries series2 = new XYSeries("Second", true, false);
series2.add(0.9, 112);
series2.add(1.1, 150);
series2.add(1.3, 175);
series2.add(1.5, 200);
series2.add(1.7, 225);
series2.add(1.9, 250);

DefaultTableXYDataset dataset = new DefaultTableXYDataset();
dataset.addSeries(series1);
dataset.addSeries(series2);
return dataset;