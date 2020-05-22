import java.awt.FlowLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class TextFieldExample extends JFrame {
    JFrame frame = new JFrame();
    public TextFieldExample()
    {
        frame = new JFrame("Test");
        Container container = frame.getContentPane();
        JTextField fld1 = new JTextField("Java C++ C");
        JTextField fld2 = new JTextField("");
        JTextField fld3 = new JTextField("");

        fld1.setColumns(5); //Now, it will not be resized.
        fld2.setColumns(7); //Now, it will not be resized.
        fld3.setColumns(9); //Now, it will not be resized.
        container.setLayout(new FlowLayout());
        container.add(fld1);
        container.add(fld2);
        container.add(fld3);
        frame.setVisible(true);
        frame.setSize(150,150);
    }
    public static void main(String[] args) {
        TextFieldExample obj = new TextFieldExample();
    }
}