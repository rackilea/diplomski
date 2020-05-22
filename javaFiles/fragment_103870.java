public class OBD2nerConsole extends java.awt.Frame implements Updatable {
    @Override
    public void update(String data) {
        textField1.setText(textField1.getText() + data);
    }
}