ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
chartLoader.loadApi(new Runnable() {

    @Override
    public void run() {
        VerticalPanel verticalPanel = new VerticalPanel();
        ColumnChart col = new ColumnChart();
        col.addSelectHandler(createSelectHandler(col));
        verticalPanel.add(col);
        col.draw(createTable(), createOptions());
        dockLayoutPanel.add(verticalPanel); 
    }
});