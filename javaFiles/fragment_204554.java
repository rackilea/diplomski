import javax.swing.JFrame;

public class Frame extends JFrame{
    public static void main (String args[]){
        Panel j = new Panel();
        j.setUpPanel();
        j.printInfo();
        Frame frame = new Frame(j);
        j.printInfo();
    }

    public Frame(Panel panel){
        super("Test");
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
    }
}