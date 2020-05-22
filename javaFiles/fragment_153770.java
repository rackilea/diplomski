public class CustomTextControl {

    // existing code...

    public static TextField newTextField() {
        return customize(new TextField());
    }

    public static TextArea newTextArea() {
        return customize(new TextArea());
    }
}