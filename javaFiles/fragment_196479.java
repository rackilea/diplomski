import javax.swing.JTextField;

public class Foo {

    protected JTextField nameTextField;

    public void foo(final User user) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                nameTextField.setText(user.getName());
            }
        });
    }
}