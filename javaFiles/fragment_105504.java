public class Game {
    private MouseListener mouseListener = new MouseListener() {
        public void onClick(MouseEvent e) {
            // application logic here
        }

        public Game() {
            DisplayPanel dp = new DisplayPanel();
            dp.addMouseListener(mouseListener);
        }
    };
}