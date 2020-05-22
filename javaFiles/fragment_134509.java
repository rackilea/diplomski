Graphics2D g = levelBufferedNew.createGraphics();
try {
    g.setComposite(AlphaComposite.Clear);
    g.fillOval(x, y, w, h); // The area you want to make transparent
}
finally {
    g.dispose();
}