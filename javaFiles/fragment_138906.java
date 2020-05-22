public void onModuleLoad() {
    RootLayoutPanel rp = RootLayoutPanel.get();

    // Create a Dock Panel
    final DockLayoutPanel dockLayoutPanel = new DockLayoutPanel(Unit.EM);
    dockLayoutPanel.setStyleName("dockpanel");
    dockLayoutPanel.getElement().getStyle().setProperty("border", "solid lightblue 4px");

    // Add text all around
    dockLayoutPanel.addNorth(new HTML("This is the first north component."), 2);
    // dockPanel.addEast(col.asWidget(), 1);
    dockLayoutPanel.addWest(new HTML("This is the west component."), 3);

    ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
    chartLoader.loadApi(new Runnable() {

        @Override
        public void run() {
            VerticalPanel verticalPanel = new VerticalPanel();
            ColumnChart col = new ColumnChart();
            verticalPanel.add(col);
            drawChart(col);
            dockLayoutPanel.add(verticalPanel);
        }
    });

    rp.add(dockLayoutPanel);
} 

private void drawChart(ColumnChart chart) {
    // Prepare the data
    DataTable dataTable = DataTable.create();
    dataTable.addColumn(ColumnType.STRING, "Density");
    dataTable.addColumn(ColumnType.NUMBER, "Copper");
    dataTable.addColumn(ColumnType.NUMBER, "Silver");
    dataTable.addColumn(ColumnType.NUMBER, "Gold");
    dataTable.addColumn(ColumnType.NUMBER, "Platinum");

    dataTable.addRows(1);

    dataTable.setValue(0, 0, "");
    dataTable.setValue(0, 1, 8.94);
    dataTable.setValue(0, 2, 10.49);
    dataTable.setValue(0, 3, 19.30);
    dataTable.setValue(0, 4, 21.45);

    // Draw the chart
    ColumnChartOptions options = ColumnChartOptions.create();
    options.setVAxis(VAxis.create("Density"));
    options.setHAxis(HAxis.create("Metel"));

    String[] colors = new String[] { "#b87333", "silver", "gold", "#e5e4e2" };
    for (int i = 0; i < colors.length; i++) {
        ColumnChartSeries series = ColumnChartSeries.create();
        series.setColor(colors[i]);
        options.setSeries(i, series);
    }
    options.setTitle("Density of Precious Metals, in g/cm^3");

    chart.draw(dataTable, options);
}