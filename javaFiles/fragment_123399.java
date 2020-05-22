import java.awt.event.*;
import javax.swing.*;

class TestKeyCode implements  KeyListener {

    public void keyPressed(KeyEvent e)
    {
        System.out.println("keyPressed(KeyEvent e)");
        int code= e.getKeyCode();
        System.out.println("code = " + code);
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(800, 800);
        TestKeyCode tkc = new TestKeyCode();
        jf.addKeyListener(tkc);
        jf.setVisible(true);
    }
}