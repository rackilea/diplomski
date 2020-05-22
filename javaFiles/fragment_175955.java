public class GUI extends JPanel {

    private final static int MAX_X = 200;
    private final static int MAX_Y = 150;
    private final Color RED = Color.RED, GREEN = Color.GREEN, BLUE = Color.BLUE;
    private final Random rColor = new Random();
    private int number;
    private Color randomColor;

    public GUI() {
        new Timer(1, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < MAX_X; x++) {
            for (int y = 0; y < MAX_Y; y++) {

                number = rColor.nextInt(3);

                if (number == 0) { randomColor = RED;
                } else if (number == 1) { randomColor = GREEN;
                } else if (number == 2) {randomColor = BLUE;
                }

                g.setColor(randomColor);
                g.drawRect(x, y, 1, 1);
            }

        }

    }
}