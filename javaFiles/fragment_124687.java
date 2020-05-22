public class NewDisplay extends JPanel {

    public NewDisplay() {
    //   setSize(800, 600);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(800, 600);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, 800, 600);
    }
}