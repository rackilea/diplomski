public class LabelUpdatingButton extends Button {

    public LabelUpdatingButton(String text, Label labelToUpdate) {
        super(text);
        getStylesheets().add("Buttons.css");
        setOnAction(e -> labelToUpdate.setText(getText()) );
    }
}