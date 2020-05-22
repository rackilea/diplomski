public class Game extends JFrame{
        //get resolution
        public static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        public static final int mWidth = gd.getDisplayMode().getWidth();
        public static final int mHeight = gd.getDisplayMode().getHeight();  

    public static void main(String[] a) {
        //create game window
        JFrame window = new JFrame();
        window.setUndecorated(true);
        Board board = new Board();

        gd.setFullScreenWindow(window);

        window.setSize(mWidth, mHeight);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(board);
        board.repaint();

        window.setVisible(true); // This needs to be last
    }
}