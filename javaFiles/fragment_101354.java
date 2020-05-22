private void addXCustomLabel(double myXValue, String myLabel) {
    boolean overlaps = false;

    tChart1.getGraphics3D().setFont(tChart1.getAxes().getBottom().getLabels().getFont());
    int tmpWidth = tChart1.getGraphics3D().textWidth(myLabel);
    int tmpX = tChart1.getAxes().getBottom().calcPosValue(myXValue) - tmpWidth / 2;

    for (int i=0; i<tChart1.getAxes().getBottom().getCustomLabels().size(); i++) {
        AxisLabelItem tmpI =tChart1.getAxes().getBottom().getCustomLabels().getItem(i);
        int tmpWidth2 = tChart1.getGraphics3D().textWidth(tmpI.getText());
        int tmpX2 = tChart1.getAxes().getBottom().calcPosValue(tmpI.getValue()) - tmpWidth2 / 2;

        if (((tmpX>tmpX2) && (tmpX<tmpX2+tmpWidth2)) ||
            ((tmpX+tmpWidth>tmpX2) && (tmpX+tmpWidth<tmpX2+tmpWidth2)) ||
            ((tmpX<tmpX2) && (tmpX+tmpWidth>tmpX2+tmpWidth2))) {
            overlaps = true;
        }
    }

    Rectangle chartRect = tChart1.getChart().getChartRect();
    if ((!overlaps) && (tmpX>chartRect.x) && (tmpX+tmpWidth<chartRect.x+chartRect.width)) {
        tChart1.getAxes().getBottom().getCustomLabels().add(myXValue, myLabel);
    }
}