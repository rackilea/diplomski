public class Test {

    public static void main(String[] args) {
        JFrame frame = new JFrame("gEngine");
        Player playerOne = new Player();
        Player playerTwo = new Player();

        // Set the proper layout manager
        frame.setLayout(new GridLayout());

        frame.add(playerOne.getMyPanel());
        frame.add(playerTwo.getMyPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
        frame.setSize(1280, 720);
        frame.setVisible(true);
    }

    public static class Player {
        private JPanel myPanel;

        public Player() {
            this.myPanel = new MyPanel();
        }

        public JPanel getMyPanel() {
            return myPanel;
        }

    }

    static class MyPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            // let the component be painted "natural"
            super.paintComponent(g);
            // Do custom painting
            g.setColor(Color.WHITE);
            g.fillRect(50, getHeight() / 2, 20, 120);
        }
    }

}