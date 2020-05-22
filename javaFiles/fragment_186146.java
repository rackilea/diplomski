public MyControl(@NamedArg("myNumber") int pMyNumber) {
    myNumber = pMyNumber;
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("myControl.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    try {
        fxmlLoader.load();
    } catch (IOException exception) {
        throw new RuntimeException(exception);
    }
    System.out.println("constructor = " + myNumber);
}