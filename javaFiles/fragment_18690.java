CTPlotArea plotArea = xssfChart.getCTChart().getPlotArea();
CTMarker ctMarker = CTMarker.Factory.newInstance();
ctMarker.setSymbol(CTMarkerStyle.Factory.newInstance());
for (CTLineSer ser : plotArea.getLineChartArray()[0].getSerArray()) {
    ser.setMarker(ctMarker);
}