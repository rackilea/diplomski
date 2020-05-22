public class TextBoxAndLabel implements HasKeyUpHandlers {

private TextBox myTextBox;
private Label myLabel;


    @Override
    public HandlerRegistration addKeyUpHandler(KeyUpHandler keyUpHandler) {
        return myTextBox.addKeyUpHandler(keyUpHandler);
    }

}