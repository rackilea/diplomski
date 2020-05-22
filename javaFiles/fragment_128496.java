public class DrawBlock extends JPanel {

    private static final long serialVersionUID = 1L;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(18, 18);
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("...");
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawRect(1, 1, 15, 15);
    }
}