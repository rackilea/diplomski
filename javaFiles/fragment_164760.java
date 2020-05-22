public class MyController {

    @FXML
    private ImageView myImageView ;

    public void initialize() { // or in an event handler, or when you externally set the image, etc
        Path imageFile = Paths.get("/path/to/image/file");
        myImageView.setImage(new Image(imageFile.toUri().toURL().toExternalForm()));

    }
}