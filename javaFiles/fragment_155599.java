public class TabbedPaneTest extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TabPane Test");

        TabPane tabPane = new TabPane();
        tabPane.setStyle("-fx-tab-min-height: 100");
        tabPane.setRotateGraphic(true);
        tabPane.setTabClosingPolicy(TabClosingPolicy.ALL_TABS);

        tabPane.getTabs().addAll(tab("Tab 1"), tab("Tab 2"));
        tabPane.setSide(Side.LEFT);

        Scene scene = new Scene(tabPane, 400, 200);
        scene.getStylesheets().add(getClass().getResource("application.css").toString());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static Tab tab(String labelText) {
        Tab tab = new Tab();
        Label label = new Label(labelText);

        tab.setGraphic(new StackPane(label));
        tab.setContent(new Label("       " + labelText + " content"));
        return tab;
    }

    public static void main(String[] args) {
        launch(args);
    }
}