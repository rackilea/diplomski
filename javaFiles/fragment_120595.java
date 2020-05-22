public class FormBuilder {

    /*
     * (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     * Scene scene
     *      Group root
     *          BorderPane borderPane
     *              TabPane tabPane
     *                  Tab stocksTab
     *                      BorderPane stockTabBorderPane
     *                          GridPane gridPane
     *          
     */

    private Stocks stockData ;
    private int size;

    private Group root ;

    public FormBuilder() {

        StockDataAccessor stockDataAccessor = new StockDataAccessor();
        stockData = stockDataAccessor.getStocks();

        root = new Group();

        TabPane tabPane = new TabPane();
        BorderPane borderPane = new BorderPane();
        BorderPane stockTabBorderPane = new BorderPane();

        Tab stocksTab = new Tab("Stocks");

        stockTabBorderPane.setTop(this.addHBox());
        stockTabBorderPane.setCenter(this.createGridPane());

        stocksTab.setContent(stockTabBorderPane);
        tabPane.getTabs().add(stocksTab);

        borderPane.setCenter(tabPane);

        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        root.getChildren().add(borderPane);



    }

    public Parent getView() {
        return root ;
    }

    private HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonCurrent = new Button("Current");
        buttonCurrent.setPrefSize(100, 20);

        Button buttonProjected = new Button("Projected");
        buttonProjected.setPrefSize(100, 20);
        hbox.getChildren().addAll(buttonCurrent, buttonProjected);

        return hbox;
    }

    private GridPane createGridPane() {

        GridPane gridPane = new GridPane();

        gridPane.setLayoutX(39);
        gridPane.setLayoutY(131.0);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setVgap(5.0);
        gridPane.setHgap(10.0);

        gridPane.add(new Label("Active"), 1,1);
        gridPane.add(new Label("Stock"), 2, 1);
        gridPane.add(new Label("Symbol"), 3, 1);
        gridPane.add(new Label("LPP"), 4, 1);
        gridPane.add(new Label("LPP"), 5, 1);
        gridPane.add(new Label("HPP"), 6, 1);
        gridPane.add(new Label("LTP"), 7, 1);

        System.out.println(this.size);
        for(int v=2;v < this.stockData.getStocks().size()+2; v++) {
            gridPane.add(new CheckBox(), 1, v);
            gridPane.add(new Label("Amazon"), 2, v);
            gridPane.add(new TextField (), 3,v);
            gridPane.add(new TextField (), 4,v);
            gridPane.add(new TextField (), 5,v);
            gridPane.add(new TextField (), 6,v);
            gridPane.add(new TextField (), 7,v);

        }

        return gridPane;
    }

}