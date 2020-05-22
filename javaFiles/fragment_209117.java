public static void main(String[] args) {
    QuestionClass questionClass = new QuestionClass();
    questionClass.setLabelText(); 
    launch(args);
}

public void start(Stage primaryStage) {
    Label label = new Label();

    // why string value wasn't assigned to string labelText in setLabelText()?
    System.out.println("labelText in start(): " + labelText); // OUTPUT: null

    label.setText(labelText);

    HBox pane = new HBox(label);

    Scene scene = new Scene(pane, 100, 100);

    primaryStage.setScene(scene);
    primaryStage.show();
}