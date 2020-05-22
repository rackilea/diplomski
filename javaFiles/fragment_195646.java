// TextInputListener.java
public class TextInputListener implements ActionListener {
    Window window;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (window.isButton0(e)) {
            //textField.setText("0")
        } else if (window.isButton1(e)) {
            //textField.setText("1")
        }
        ...
    }
}