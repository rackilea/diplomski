import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AnotherBrickInTheWall extends JApplet {

//Component declaration
    JLabel directions;
    JTextField input;
    //Variable declaration
    int startX = 0;
    int startY = 50;
    int width = 50;
    int height = 20;
    int spacing = 2;

    //Method declaration
    public void init() {
        getContentPane().setBackground(new Color(128, 128, 128));//Changes backround of JApplet to black
        //Set JTextField and JLabel
        setLayout(new FlowLayout());
        directions = new JLabel("Enter in any number between 1 and 20 and then press Enter on your keyboard.");
        input = new JTextField(10);
        add(directions);
        add(input);
    }

    //Method declaration 
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int row = 0; row < 8; row++) {
            int y = startY + (row * (height + spacing));
            for (int col = 0; col < 8; col++) {
                int x = startX + (col * (width + spacing));
                System.out.println(x + "x" + y);
                g.setColor(Color.RED);
                g.fillRect(x, y, width, height);
            }
        }
    }
}