@Override
public void initialize(URL url, ResourceBundle rb) {
    img.imageProperty().bind(Bindings.createObjectBinding(() -> {
        File file = new File("src/images/"+txt.getText());
        if (file.exists()) {
            return new Image(file.toURI().toString());
        } else {
            return null ;
        }
    }, txt.textProperty());
}