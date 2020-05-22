import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ScrollPaneToTextArea {

    private JTextArea textArea;
    private JFrame frame;
    private JScrollPane scroll;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ScrollPaneToTextArea().createAndShowGui();
            }
        });
    }

    public void createAndShowGui() {
        frame = new JFrame("ScrollPane to TextArea");
        textArea = new JTextArea(10, 20); //Rows and cols to be displayed
        scroll = new JScrollPane(textArea);
//      scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        frame.add(scroll); //We add the scroll, since the scroll already contains the textArea
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}