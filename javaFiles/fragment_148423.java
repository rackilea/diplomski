public class UploadExample extends CustomComponent implements BookExampleBundle {
private static final long serialVersionUID = -4292553844521293140L;

public void init (String context) {
    //... omitted for brevity
        basic(layout);
    //... omitted for brevity
}

void basic(VerticalLayout layout) {
    final Image image = new Image("Uploaded Image");
    //the rest of the example code goes here