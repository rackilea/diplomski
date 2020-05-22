public class MyTextField extends JTextField {
public MyTextField (){
    addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
            }

            @Override
            public void focusGained(FocusEvent arg0) {
            }
        });
}
}