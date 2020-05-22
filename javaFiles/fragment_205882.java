import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.UIManager;

public class MyComboBox {

    private Vector<String> listSomeString = new Vector<String>();
    private JComboBox someComboBox = new JComboBox(listSomeString);
    private JComboBox editableComboBox = new JComboBox(listSomeString);
    private JComboBox non_EditableComboBox = new JComboBox(listSomeString);
    private JFrame frame;

    public MyComboBox() {
        listSomeString.add("-");
        listSomeString.add("Snowboarding");
        listSomeString.add("Rowing");
        listSomeString.add("Knitting");
        listSomeString.add("Speed reading");
        someComboBox.setPrototypeDisplayValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        someComboBox.setFont(new Font("Serif", Font.BOLD, 16));
        someComboBox.setEditable(true);
        someComboBox.getEditor().getEditorComponent().setBackground(Color.YELLOW);
        ((JTextField) someComboBox.getEditor().getEditorComponent()).setBackground(Color.YELLOW);
        editableComboBox.setPrototypeDisplayValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        editableComboBox.setFont(new Font("Serif", Font.BOLD, 16));
        editableComboBox.setEditable(true);
        JTextField text = ((JTextField) editableComboBox.getEditor().getEditorComponent());
        text.setBackground(Color.YELLOW);
        non_EditableComboBox.setPrototypeDisplayValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        non_EditableComboBox.setFont(new Font("Serif", Font.BOLD, 16));
        frame = new JFrame();
        frame.setLayout(new GridLayout(0, 1, 10, 10));
        frame.add(someComboBox);
        frame.add(editableComboBox);
        frame.add(non_EditableComboBox);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyComboBox aCTF = new MyComboBox();
            }
        });
    }
}