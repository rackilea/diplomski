public class FractalPanel extends JPanel {
    final FractalSquare square = new FractalSquare(450, 350);

    public FractalPanel() {
        add(square);
    }

    public static void main(String[] args) {
        FractalPanel fractalPanel = new FractalPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(fractalPanel);
        frame.pack();
        frame.setVisible(true);

        Thread squareThread = new Thread(() -> {
            try {
                fractalPanel.square.render();
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
        });
        squareThread.start();
    }
}

class Fractal extends JComponent {
    final BufferedImage image;
    final Graphics2D offscreenGraphics;

    public Fractal(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        offscreenGraphics = image.createGraphics();
    }

    // Copy the offscreen image to the main graphics context
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        synchronized (image) { // synchronize with the render thread
            g2.drawImage(image, 0, 0, null);
        }
    }
}

class FractalSquare extends Fractal {
    public FractalSquare(int width, int height) {
        super(width, height);
    }

    public void render() throws InterruptedException {
        drawSquares(getWidth() / 2, getHeight() / 2, 100, 7);
    }

    public void drawSquares(int x, int y, int side, int size) throws InterruptedException {

        // Sleep for 10ms between frames
        Thread.sleep(10);

        if (size > 2) {
            size--;

            synchronized (image) { // synchronize with the draw thread
                offscreenGraphics.setColor(Color.BLUE);
                System.out.printf("Filling [%d, %d, %d, %d]\n", x - side / 2, y - side / 2, side, side);
                offscreenGraphics.fillRect(x - side / 2, y - side / 2, side, side);
            }

            // Tell Swing that we've updated the image and it needs to be redrawn
            repaint();

            side = side / 2;
            x = x - side;
            y = y - side;
            drawSquares(x, y, side, size);
            drawSquares(x + side * 2, y, side, size);
            drawSquares(x, y + side * 2, side, size);
            drawSquares(x + side * 2, y + side * 2, side, size);
        }
    }
}