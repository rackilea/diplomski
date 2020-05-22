import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class main_class implements KeyListener {

    static final int FRAME_WIDTH = 800;
    static final int FRAME_HEIGHT = 500;
    JFrame f;

    public main_class() {
        f = new JFrame("Pong");

        JPanel gui = new JPanel();
        gui.setFocusable(true);
        gui.addKeyListener(this);
        f.setContentPane(gui);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setResizable(false);

        f.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        f.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // this will steal the focus for KeyEvents, or rather..
        // Pong_Test_1 p = new Pong_Test_1();
        int keyCode = e.getKeyCode();
        System.out.println(e);
        switch (keyCode) {
            case KeyEvent.VK_UP:
                Pong_Test_1.p2_pos_y--;
                break;
            case KeyEvent.VK_DOWN:
                Pong_Test_1.p2_pos_y++;
                break;
            case KeyEvent.VK_Q:
                Pong_Test_1.p1_pos_y++;
                break;
            case KeyEvent.VK_A:
                Pong_Test_1.p1_pos_y++;
                break;
        }
        // ..adding it will steal the content area & focus
        //add(p);
        f.repaint();
    }

    /**
     * Handle the key released event from the text field.
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        // TODO code application logic here
        main_class c = new main_class();
    }
}