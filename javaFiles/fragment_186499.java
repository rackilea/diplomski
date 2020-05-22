try {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
    loader.setController(this);
    loader.setRoot(this);
    loader.load();

} catch (IOException e) {
    e.printStackTrace();
}