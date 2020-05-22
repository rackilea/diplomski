public class JavaFxSample extends Application {

@Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("Enter number and hit the button");
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    Label label1To6 = new Label("1.0-6.0:");
    grid.add(label1To6, 0, 1);
    TextField textField1To6 = new TextField();

    textField1To6.focusedProperty().addListener((arg0, oldValue, newValue) -> {
        if (!newValue) { // when focus lost
                if (!textField1To6.getText().matches("[1-5](\\.[0-9]{1,2}){0,1}|6(\\.0{1,2}){0,1}")) {
                    // when it not matches the pattern (1.0 - 6.0)
                    // set the textField empty
                    textField1To6.setText("");
                }
            }
        });
    grid.add(textField1To6, 1, 1);
    grid.add(new Button("Hit me!"), 2, 1);
    Scene scene = new Scene(grid, 300, 275);
    primaryStage.setScene(scene);
    primaryStage.show();
}

public static void main(String[] args) {
    launch(args);
}

}