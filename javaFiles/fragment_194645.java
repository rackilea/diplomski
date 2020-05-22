public UC2Controller(DomeinController dc) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("UC2.fxml"));
    loader.setController(this);
    loader.setRoot(this);
    this.dc = dc;
    try {
        loader.load();
    } catch (IOException ex) {
        throw new RuntimeException(ex); // cannot recover from this -> rethrow exception
    }

}