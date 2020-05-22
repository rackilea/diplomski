package image;

import javax.swing.JFrame;

public class Explorer extends JFrame {

    private static final long serialVersionUID = 1L;

    public static int WIDTH = 400;
    public static int HEIGHT = 400;

    public Explorer() {
        super("Explorer");
        add(new Game(WIDTH, HEIGHT));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Explorer();
    }

}