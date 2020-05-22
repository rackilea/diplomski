//First, declare a global Pane.
static Pane pane = new Pane();

//Make your pie() method return the pie VBox.
public VBox pie() {
    /*Blah blah blah, making the pie...*/
    return pie//Remember, pie is a VBox, which is why we are returning the VBox.
}

//Later, when you build your window, add the pie and the buttons to the GLOBAL PANE...
public Stage window() {
    pane.getChildren().add(pie());      //...right here.
    pane.getChildren().addAll(userControl());
    /*Build the primary stage...*/
    return primaryStage;
}