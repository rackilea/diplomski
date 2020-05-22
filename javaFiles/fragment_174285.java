import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TTest extends Applet{
    @Override
    public void init() {
        // TODO Auto-generated method stub
        super.init();
        this.setSize(400, 400);
        addKeyListener(new KeyListener());

    }
    class KeyListener extends KeyAdapter{
        public KeyListener(){

        }

        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            super.keyPressed(e);
            switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                System.out.println("Pressed up arrow!");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Pressed down arrow!");
                break;
            default:
                System.out.println("You pressed: " + e.getKeyCode());
            }
        }

    }
}