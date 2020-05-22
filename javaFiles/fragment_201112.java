@Override
public void start(Stage primaryStage) {

    Scene scene = new Scene(new StackPane(), 300, 250);

    primaryStage.setScene(scene);

    primaryStage.setOnShown(e -> {
        CustomTitledPane customTitledPane = new CustomTitledPane("Title", new StackPane(new Label("Graphic to the Right")));
        scene.setRoot(customTitledPane);
        customTitledPane.applyCss();
        customTitledPane.layout();

        // title region
        Node titleRegion=customTitledPane.lookup(".title");
        // padding
        Insets padding=((StackPane)titleRegion).getPadding();
        // image width
        double graphicWidth=customTitledPane.getGraphic().getLayoutBounds().getWidth();
        // arrow
        double arrowWidth=titleRegion.lookup(".arrow-button").getLayoutBounds().getWidth();
        // text
        double labelWidth=titleRegion.lookup(".text").getLayoutBounds().getWidth();

        double nodesWidth = graphicWidth+padding.getLeft()+padding.getRight()+arrowWidth+labelWidth;

        customTitledPane.graphicTextGapProperty().bind(customTitledPane.widthProperty().subtract(nodesWidth));
    });

    primaryStage.show();

}

class CustomTitledPane extends TitledPane {

    public CustomTitledPane(String titleText, Node node) {
        super(titleText, node);
        setAnimated(true);
        setCollapsible(true);
        ImageView img = new ImageView(new Image(getClass().getResource("unlock24.png").toExternalForm()));
        img.setFitHeight(10d);
        img.setPreserveRatio(true);
        img.setSmooth(true);
        setGraphic(img);
        setContentDisplay(ContentDisplay.RIGHT);
    }
}