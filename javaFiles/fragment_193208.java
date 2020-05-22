/**
 *
 * @author Momir Sarac
 */
public class DeleteSpecificLineFromTextArea extends Application {

    @Override
    public void start(Stage primaryStage) {

        TextArea textArea = new TextArea();
        Button button = new Button("Get it");


        textArea.setText("Adam Smith 32\nJenny Curry 52\nTako Yoshimoto 56\n");

        String nameText = "Jenny Curry 52";

         button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

        for (String line : textArea.getText().split("\n")) {
            if (line.contains(nameText)) {
                textArea.setText(textArea.getText().replace(line, ""));
            }
        }
        textArea.setText(textArea.getText().replaceAll("[\\\\\\r\\\\\\n]+", "\n"));
            }
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(textArea,button);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}