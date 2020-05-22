public class Controller {
    public void startMethod() {
        final UIClass myUI = new UIClass();
        myUI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                handleUIInformation(myUI);
            }
        }
    }

    private void handleUIInformation(UIClass myUI) {
        String textval = myUI.textField.getText();
        // here you do whatever you want with the text
    }
}

public class UIClass {
    JButton button;
    JTextField textField;
    public UIClass() {
        button = new JButton();
        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    button.doClick();
                }
            }
        });
    }

    public void addActionListener(ActionListener al) {
        button.addActionListener(al);
    }
}