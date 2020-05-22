for (int i = 0;i < data.getItemCount(0) - 1;i++)
    {
    double x1 = data.getSeries(0).getDataItem(i).getXValue();
    double x2 = data.getSeries(0).getDataItem(i + 1).getXValue();

    double y1 = data.getSeries(0).getDataItem(i).getYValue();
    double y2 = data.getSeries(0).getDataItem(i + 1).getYValue();

    double angle = Math.atan2(y1 - y2, x2 - x1) + Math.PI;
    XYPointerAnnotation arrow = new XYPointerAnnotation("",x1,y1,angle);

    if (i == 0)
        {
        arrow.setText("Start");
        }
    else if (i % 5 == 0)
        {
        arrow.setText(Integer.toString(i));
        }

    arrow.setLabelOffset(15.0);
    arrow.setToolTipText(Integer.toString(i));
    _originalPlot.addAnnotation(arrow);
    }