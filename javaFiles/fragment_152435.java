XSSFChart chart = (XSSFChart)drawing.createChart(anchor);

    // this will set blank values as gaps in the chart so you 
    // can accurately plot data series of different lengths
    CTDispBlanksAs disp = CTDispBlanksAs.Factory.newInstance();
    disp.setVal(STDispBlanksAs.GAP);
    chart.getCTChart().setDispBlanksAs(disp);


    // setup chart, axes, data series, etc


    chart.plot(data, new ChartAxis[] { bottomAxis, leftAxis });

    // this must occur after the call to chart.plot above
    CTPlotArea plotArea = chart.getCTChart().getPlotArea();
    for (CTLineChart ch : plotArea.getLineChartList()) {
        for (CTLineSer ser : ch.getSerList()) {
            CTBoolean ctBool = CTBoolean.Factory.newInstance();
            ctBool.setVal(false);
            ser.setSmooth(ctBool);
        }
    }