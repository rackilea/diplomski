Color color = new Color(0.89411765f, 0.5686275f, 0.019607844f);
int argb = color.getRGB();

Graphics2D g = image.createGraphics();
try {
    g.setColor(color);
    g.fillRect(10, 10, 50, 50);
}
finally {
    g.dispose();
}