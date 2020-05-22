public class SOSCanvas extends JPanel {

    public SOSCanvas() {
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int dimension = 5;//game.getDimension();

        int width = getWidth() - 1;
        int height = getHeight() - 1;

        int cellSize = Math.min(width, height);
        int xOffset = (width - cellSize) / 2;
        int yOffset = (height - cellSize) / 2;

        g.drawRect(xOffset, yOffset, cellSize, cellSize);

        // drawing horizontal lines
        for (int i = 1; i < dimension; i++) {
            g.drawLine(
                            xOffset, 
                            yOffset + (i * (cellSize / dimension)), 
                            xOffset + cellSize, 
                            yOffset + (i * (cellSize / dimension)));
        }

        // drawing vertical lines
        for (int i = 1; i < dimension; i++) {
            g.drawLine(
                            xOffset + (i * (cellSize / dimension)), 
                            yOffset, 
                            xOffset + (i * (cellSize / dimension)), 
                            yOffset + cellSize);
        }
    }

}