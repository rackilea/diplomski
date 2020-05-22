import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;


public class FullGUI extends JFrame

{
    public FullGUI() // constructor
    {
        getContentPane().add(new JRadioButton("Horizontal"), BorderLayout.WEST);
        getContentPane().add(new JRadioButton("Vertical"), BorderLayout.WEST);
        getContentPane().add(new JTextArea("Instructions to player will go here"), BorderLayout.CENTER);
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Battleship!");
        pack(); //sets appropriate size for frame
        setVisible(true);
    }

}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            new FillGU();
        }
    });
}