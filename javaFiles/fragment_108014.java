public class MyTextField extends JTextField implements FocusListener  {
    public MyTextField (){
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent event) {

    }

    @Override
    public void focusLost(FocusEvent event) {

    }
}