import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;

public class PicLoad extends JFrame {

PicLoad(){
    add(new Board());
    pack();

    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}

public static void main(String[] args) {
    new PicLoad();
}
}

class Board extends JPanel {

    int dx;
    int dy;
    int x = 100;
    int y = 10;
    Image star = new BufferedImage(40,40,BufferedImage.TYPE_INT_RGB);
Board() {
        // I figured here is the keylister, i need it to move the dx and dy around.
        addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT) dx -= 1;
            if(key == KeyEvent.VK_RIGHT) dx += 1;
            if(key == KeyEvent.VK_UP) dy += 1;
            if(key == KeyEvent.VK_DOWN) dy -= 1;
            repaint();
         }
        });
        initBoard();
}

void initBoard() {
    setBackground(Color.RED);
    /* See Should I avoid the use of set(Preferred|Maximum|Minimum)Size methods
    in Java Swing? http://stackoverflow.com/q/7229226/418556  (Yes.) */
    //setPreferredSize(new Dimension(500,500));
    setFocusable(true); // VERY IMPORTANT!
}

@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawStar(g);
}

@Override
public Dimension getPreferredSize() {
    return new Dimension(500,100);
}

private void drawStar(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.drawImage(star, dx + x, dy+ y, this);
    //Toolkit.getDefaultToolkit().sync();  //  What were you thinking?!?
    //g.dispose(); // Don't dispose of a Graphics object unless you create it!
}
}