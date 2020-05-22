public class WinTest extends Canvas {

private static final long serialVersionUID = -369751247370351003L;

public WinTest(int h, int w, String title, Wincall game, ME me) {

    JFrame f = new JFrame(title);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(h, w);
    f.add(game);
    f.setVisible(true);
    f.requestFocus();
    f.setResizable(false);
    f.setFocusable(true);
    // f.addMouseMotionListener(me);
    game.addMouseMotionListener(me);
    game.run();
 }
}