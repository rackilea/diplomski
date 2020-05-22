// Window.java
public class Window {
    TextField textField;
    JButton button1;
    JButton button2;
    ...
    void setText(String text) {
        textField.setText(text);
    }
}

// TextInputListener.java
public class TextInputListener implements ActionListener {
    Window window;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (window.isButton0(e)) {
            window.setText("0");
        } else if (window.isButton1(e)) {
            window.setText("1");
        }
        ...
    }
}