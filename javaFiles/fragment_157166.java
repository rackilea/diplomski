DefaultCategoryDataset barChartDataset = new DefaultCategoryDataset();

for (int l = 0; l < data.length; l++) {

       // barChartDataset.setValue(new Double(data[l]), "Scores", stu);
       barChartDataset.addValue(new Double(data[l]), "Scores", stu);
       System.out.println(data[l]);
    }

    JFreeChart barChart = ChartFactory.createBarChart3D("Summary", "Name", "Scores", barChartDataset, PlotOrientation.VERTICAL, false, true, false);