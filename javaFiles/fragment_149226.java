public class SomeClass {

    private Label tekst ;

    // ...

    private Button createButton(String buttonText) {
        Button button = new Button(buttonText);
        button.getStylesheets().add("Buttons.css") ; 
        button.setOnAction(e -> tekst.setText(buttonText));
        return button ;
    }
}