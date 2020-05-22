CategoryPlot cplot = (CategoryPlot)chart.getPlot();
    cplot.setBackgroundPaint(SystemColor.inactiveCaption);//change background color

    //set  bar chart color

    ((BarRenderer)cplot.getRenderer()).setBarPainter(new StandardBarPainter());

    BarRenderer r = (BarRenderer)chart.getCategoryPlot().getRenderer();
    r.setSeriesPaint(0, Color.blue);