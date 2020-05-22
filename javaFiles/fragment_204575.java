import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class GUItest extends JFrame  {
    private JEditorPane myEditorPane;
    private JScrollPane myScrollPane;

    public GUItest(){
        myEditorPane = new JEditorPane(); 
        myScrollPane = new JScrollPane(myEditorPane);
        myScrollPane.setPreferredSize(new Dimension(400, 100));
        getContentPane().add(myScrollPane);
        myEditorPane.setContentType("text/html");
        myEditorPane.setText("<html>" + "test<br>test<br>test<br>test<br>test<br>test<br>test<br>test<br>test<br>test<br>test<br>test<br>" + "</html>");
        Rectangle rect = new Rectangle(1,1,1,1);
        pack();
        setVisible(true);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                myEditorPane.scrollRectToVisible(rect);
            }
        });
    }    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new GUItest();
            }
        });
    }
}