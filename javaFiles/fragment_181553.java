import java.io.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class GTAIntro extends JPanel {
private static final long serialVersionUID = 1L;

public GTAIntro() {
    setSize(800,800);
    setLayout(null);

    JTextArea textpanel = new JTextArea();
    textpanel.setLineWrap(true);
    textpanel.setWrapStyleWord(true);
    textpanel.setEditable(false);
    try{
        FileInputStream fstream = new FileInputStream("D:\\Facultate\\anul 2\\Java Workspace\\Encyclopedia\\src\\text\\gta\\gtaintro.txt");
        // do not use DataInputStream to read text
        // DataInputStream in = new DataInputStream(fstream);
        Reader reader = new InputStreamReader(fstream);
        textpanel.read(reader, fstream);
    }catch(Exception e){System.err.println("Error: " + e.getMessage());}
    textpanel.setBounds(100, 222, 593, 528);
    add(textpanel);

    JButton button_1 = new JButton("");
    button_1.setIcon(new ImageIcon("D:\\Facultate\\anul 2\\Java Workspace\\Encyclopedia\\src\\icons\\back.png"));
    button_1.setEnabled(false);
    button_1.setBounds(10, 700, 50, 50);
    add(button_1);

    JButton button = new JButton("");
    button.setIcon(new ImageIcon("D:\\Facultate\\anul 2\\Java Workspace\\Encyclopedia\\src\\icons\\next.png"));
    button.setBounds(740, 700, 50, 50);
    add(button);

    JLabel rockstarlogo = new JLabel("");
    rockstarlogo.setIcon(new ImageIcon("D:\\Facultate\\anul 2\\Java Workspace\\Encyclopedia\\src\\icons\\gta\\rockstar-logo.png"));
    rockstarlogo.setBounds(10, 11, 150, 150);
    add(rockstarlogo);

}
}