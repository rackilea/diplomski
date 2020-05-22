package explodingimage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Game {
private JFrame frame;
private GamePanel panel;

public Game() {
    this.frame = new JFrame();
    this.panel = new GamePanel();

    frame.getContentPane().add(panel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}

public void start(){
    new Timer(10, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            panel.getTerrain().update();
            panel.repaint();
        }
    }).start();
}

public static void main(String[] args) {
    new Game().start();
}

 }