public class Main extends Application {
public static void main(String[] args) {
   Application.launch(args);
}

@Override
public void start(Stage primaryStage) {
primaryStage.setTitle("BorderPane Test");

//Creating StackPane
StackPane sp = new StackPane();

// add Combobox to scene
ComboBox<String> combobox = new ComboBox<String>();
ObservableList<String> items = FXCollections.observableArrayList("RED", "BLUE",     "GREEN", "YELLOW", "BLACK");
combobox.setItems(items);
combobox.setTranslateX(250);
combobox.setTranslateY(300);
combobox.setPromptText("Circle Color");
sp.getChildren().add(btn);

//Adding StackPane to the scene
Scene scene = new Scene(sp,300,200);
primaryStage.setScene(scene);
primaryStage.show();
}
}