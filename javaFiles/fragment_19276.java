HBox top = new HBox(
    new CustomLabel("White", "white-check"),
    new CustomLabel("Light Gray", "lightgray-check")
);
. . . 
public class CustomLabel extends Label {
    public CustomLabel(String text, String styleClass) {
        super(text);
        getStyleClass().add(styleClass);
        setMinWidth(160);
        setMinHeight(60);
     }
}