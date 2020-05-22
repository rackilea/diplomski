class DrawingFrame extends JFrame {

    private Image bullseye = new Bullseye(20,20); //width,height


    public void paint(Graphics g) {
        g.drawImage(bullseye,10,20);
        g.drawImage(bullseye,20,20);
        g.drawImage(bullseye,30,20);
    }

}

class Main {
    public static void main(String[] args) {
        DrawingFrame frame = new DrawingFrame();

        // later
        frame.setVisible(true);
    }
}