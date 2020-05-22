import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainClass extends JFrame implements ActionListener {

    public static void main(String[] args) {
        System.out.println("Program Window1");
        MainClass glt = new MainClass();
        glt.setVisible(true);
    }

    // ..... other stuff
    public MainClass() {
        super("Fixed Timestep Game Loop Test");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2));

        System.out.println("Program Window2");
        MainPanel gamePanel = new MainPanel();

        cp.add(gamePanel, BorderLayout.CENTER);
        cp.add(p, BorderLayout.SOUTH);
        setSize(500, 500);
    }

    // .... other stuff

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }
}

class MainPanel extends JPanel {

    private GameWindow currentWindow;

    public MainPanel() {
        currentWindow = new StartWindow(this);
    }

//    public void paintComponent(Graphics g) {
//        g.drawRect(0, 0, 200, 200); // <-- can see on the window
//    }

    // this should be protected, not public and should call super method 
    @Override  
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0, 0, 200, 200); // <-- can see on the window
        currentWindow.draw(g);
    }
}

interface Drawable {
    void draw(Graphics g);
}

abstract class GameWindow implements Drawable {
    // contains game loop and update functions and so on
}

class StartWindow extends GameWindow {

    MainPanel _parentWindow;

    public StartWindow(MainPanel parentWindow) {
        super();
        _parentWindow = parentWindow;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(20, 20, 100, 100);
    }
}