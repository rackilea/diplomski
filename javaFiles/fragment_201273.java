public class SimpleButtonApp extends Application {

@Override
public void start(Stage stage) throws Exception {
    GridPane container = new GridPane();

    Label displayLabel = new Label();

    String[][] labels = {
            {"Lsh", "Rsh", "Or", "Xor", "Not", "And"},
               {"↑", "Mod", "CE", "C", "⌫", "÷"},
                 {"A", "B", "7", "8", "9", "×"},     
                 {"C", "D", "4", "5", "6", "−"},
                 {"E", "F", "1", "2", "3", "+"}, 
                 {"(", ")", "±", "0", ".", "="}};

    for(int i = 0; i < labels.length; i++) {
        for(int j = 0; j < labels[i].length; j++) {
            String label = labels[i][j];

            Button button = new Button(label);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    displayLabel.setText(displayLabel.getText() + label);
                }
            });
            container.add(button, i, j);
        }
    }

    container.getChildren().addAll(button, displayLabel);
    Scene scene = new Scene(container, 300, 100);
    stage.setScene(scene);
    stage.show();
}

public static void main(String[] args) {
    launch(args);
}
}