public static void main(String[] args) {
    launch(args);
}

public void start(Stage primaryStage) {
    Label label = new Label();
    //this will call the method on the current instance of your Question class so it will work
    setLabelText();
    // why string value wasn't assigned to string labelText in setLabelText()?
    System.out.println("labelText in start(): " + labelText); // OUTPUT: null

    label.setText(labelText);

    HBox pane = new HBox(label);

    Scene scene = new Scene(pane, 100, 100);

    primaryStage.setScene(scene);
    primaryStage.show();
}