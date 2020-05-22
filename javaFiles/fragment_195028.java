import java.awt.Container;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class QueueTest {

    public static void main(String args[]) {
        String title = (args.length == 0 ? "TextArea Example" : args[0]);
        JFrame frame = new JFrame(title);
        Container content = frame.getContentPane();
        content.setLayout(new GridLayout(0, 2));
        JTextArea leftTextArea = new JTextArea();
        JScrollPane rightPane = new JScrollPane(leftTextArea);
// JScrollPane leftPane = new JScrollPane(rightTextArea);
        JTextArea rightTextArea = new JTextArea();/* {
            public boolean isManagingFocus() { // i don't know why you have done this
                return false;
            }
        };*/
        try {
            rightTextArea.read(new FileReader("C:\\Denemeler\\deneme2.txt"), null);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        content.add(leftTextArea);
        leftTextArea.paste();
        rightTextArea.paste();
        JScrollPane leftPane1 = new JScrollPane(rightTextArea);
        JScrollPane rightPane1 = new JScrollPane(leftTextArea);
        try {
            leftTextArea.read(new FileReader("C:\\Denemeler\\deneme1.txt"), null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        content.add(leftPane1);
        content.add(rightPane1);
        frame.setSize(250, 150);
        frame.setVisible(true);
    }
}