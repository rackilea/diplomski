LogAxis yAxis = new LogAxis("Transaction Time (ms)");

        yAxis.setBase(10);
        plot.setRangeAxis(yAxis);
        yAxis.setTickUnit(new NumberTickUnit(1));
        yAxis.setMinorTickMarksVisible(true);
        yAxis.setAutoRange(true);
        plot.setRangeAxis(yAxis);
        plot.getRangeAxis().setLabelFont(new Font("SansSerif", Font.BOLD, 14));
        plot.getRangeAxis().setTickLabelFont(new Font("SansSerif", Font.BOLD, 12));

        Double maximum = (Double) DatasetUtilities.findMaximumRangeValue(dataset);

        plot.getRangeAxis().setLowerBound(10);
        plot.getRangeAxis().setUpperBound(maximum * 1.6);