public class TowersOfHanoi extends JPanel {

    private int clock = 0;
    private Color circles = new Color(176, 56, 251);

    public static void main(String[] args) {
        // Print the shapes and frame
        TowersOfHanoi drawRectangle = new TowersOfHanoi();
        JFrame frame = new JFrame("Towers of Hanoi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(drawRectangle);
        frame.setSize(1250, 800);
        frame.setVisible(true);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawRectangle.nextFrame();
                drawRectangle.repaint();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    public void nextFrame() {
        clock++;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        frame1(g);
        if (clock >= 1) {
            frame2(g);
        }
        if (clock >= 2) {
            frame3(g);
        }
    }

    private Color frame1(Graphics g) {
        Color pegs = new Color(251, 129, 56);
        g.setColor(pegs);

        // peg 1
        g.fillRect(250, 300, 25, 450);
        // peg 2
        g.fillRect(600, 300, 25, 450);
        // peg 3
        g.fillRect(950, 300, 25, 450);
        // bottom
        g.fillRect(200, 700, 825, 50);
        // create a color for circles
        // cirle 7 (Labeled from bottom to top)
        g.setColor(circles);
        g.fillOval(60, 640, 400, 60);
        g.setColor(Color.BLACK);
        g.drawOval(60, 640, 400, 60);
        return circles;
    }

    private void frame2(Graphics g) {
        // circle 6
        g.setColor(circles);
        g.fillOval(85, 580, 350, 60);
        g.setColor(Color.BLACK);
        g.drawOval(85, 580, 350, 60);
    }

    private void frame3(Graphics g) {
        // circle 5
        g.setColor(circles);
        g.fillOval(110, 520, 300, 60);
        g.setColor(Color.BLACK);
        g.drawOval(110, 520, 300, 60);
        // circle 4
        g.setColor(circles);
        g.fillOval(135, 465, 250, 55);
        g.setColor(Color.BLACK);
        g.drawOval(135, 465, 250, 55);
        // circle 3
        g.setColor(circles);
        g.fillOval(160, 420, 200, 45);
        g.setColor(Color.BLACK);
        g.drawOval(160, 420, 200, 45);
        // circle 2
        g.setColor(circles);
        g.fillOval(185, 380, 150, 40);
        g.setColor(Color.BLACK);
        g.drawOval(185, 380, 150, 40);
        // circle 1
        g.setColor(circles);
        g.fillOval(210, 345, 100, 35);
        g.setColor(Color.BLACK);
        g.drawOval(210, 345, 100, 35);
    }

}