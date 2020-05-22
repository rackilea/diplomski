import javax.swing.JTextField;
public class MyClass {
    private JTextField jtf = null;
    public MyClass(Object obj) {
        jtf = (JTextField) obj;
    }
    public void setString(String str) {
        jtf.setText(str);
    }
}