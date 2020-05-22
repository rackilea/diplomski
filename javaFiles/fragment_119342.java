public class ColorDemo extends JPanel {

    private final int gradientSize = 18;
    private final Color lighterColor = new Color(250, 250, 250);
    private final Color darkerColor = new Color(225, 225, 230);
    private final Color edgeColor = new Color(140, 145, 145);
    private final Stroke edgeStroke = new BasicStroke(1);
    private final GradientPaint upperGradient = new GradientPaint(
            0, 0, lighterColor,
            0, gradientSize, darkerColor);


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint lowerGradient = new GradientPaint(
                0, getHeight()-gradientSize-1, darkerColor,
                0, getHeight(), lighterColor);
        g2.setPaint(upperGradient);
        g2.fillRect(0, 0, getWidth()-1 , gradientSize);
        g2.setPaint(darkerColor);
        g2.fillRect(0, gradientSize, getWidth()-1, getHeight()-gradientSize-1);
        g2.setPaint(lowerGradient);
        g2.fillRect(0, getHeight()-gradientSize, getWidth()-1, getHeight()-1);
        g2.setStroke(edgeStroke);
        g2.setPaint(edgeColor);
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1,
                               gradientSize/2, gradientSize/2);
    }
}