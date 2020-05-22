private void Load(){
    final FXMLLoader loader = new FXMLLoader();
    loader.setRoot(this);
    loader.setClassLoader(this.getClass().getClassLoader());
    loader.setLocation(this.getClass().getResource("Hybrid.fxml"));

    // add this line, and remove the fx:controller attribute from the fxml file:
    loader.setController(this);

    try{
        final Object root = loader.load();
        assert root == this;
    } catch (IOException ex){
        throw new IllegalStateException(ex);
    }
    assert this == loader.getController();
}