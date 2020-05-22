package test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MyFramework {
    static class MyKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            keyPressed(e.getKeyCode());
        }
        public void keyPressed(int keyCode) {}

        @Override public void keyTyped(KeyEvent e) { }
        @Override public void keyReleased(KeyEvent e) { }
    }

    static class MyFrameworkClass extends MyKeyListener {
        @Override
        public void keyPressed(int keyCode) {
            System.out.println(String.format("Key pressed: '%d'", keyCode));
        }
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Framework test");
        jFrame.setSize(200, 200);
        jFrame.addKeyListener(new MyFrameworkClass());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}