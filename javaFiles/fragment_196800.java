import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class TestWidth {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextPane newsTextPane = new JTextPane();
        newsTextPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(newsTextPane);

        frame.add(scrollPane);
        frame.setSize(300, 250);
        frame.setVisible(true);

        System.out.println("Height : " + scrollPane.getViewport().getSize().height + "\nWidth :" + scrollPane.getViewport().getSize().width);
    }
}