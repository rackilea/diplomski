class MyCanvas extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        g2D.translate(transX, transY);
        g2D.rotate(rotateTheta, rotateX, rotateY);
        g2D.scale(scaleX, scaleY);

        BasicStroke stroke = new BasicStroke(width);
        g2D.setStroke(stroke);

        drawHome(g2D);
    }
...
}