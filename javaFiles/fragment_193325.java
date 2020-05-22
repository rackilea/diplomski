TabPane tabPane = new TabPane(
    new Tab("Tab 1", new ChartViewer(createChart("One"))),
    new Tab("Tab 2", new ChartViewer(createChart("Two"))),
    new Tab("Tab 3", new ChartViewer(createChart("Three")))
);
stage.setScene(new Scene(tabPane));