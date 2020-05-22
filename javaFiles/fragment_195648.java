// MyApp.java
public class MyApp {
    public static void main(String[] args) {
        Window myWindow = new Window();
        TextInputListener myTextInputListener = new TextInputListener();

        myWindow.setActionListener(myTextInputListener);
        myTextInputListener.listenTo(myWindow);
    }
}

// Window.java
public class Window {
    TextField textField;
    JButton button1;
    JButton button2;
    ...
    void setText(String text) {
        textField.setText(text);
    }
    public void setActionListener(ActionListener l) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(l);
        }
    }
}

// TextInputListener.java
public class TextInputListener implements ActionListener {
    Window window;

    public void listenTo(Window window) {
        this.window = window;
    }

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