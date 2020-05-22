import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;


public class MyWordGame extends JApplet {

    public void init(){
        add(new JButton("Test"));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyWordGame game=new MyWordGame();
        JFrame myFrame=new JFrame("Test");
        myFrame.add(game);
        myFrame.pack();
        myFrame.setVisible(true);
        game.init();

    }

}