JPanel panel = new JPanel()
boardCaptured = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
Graphics2D graphic = boardCaptured.createGraphics();
panel.setSize(500,500);
panel.paint(graphic);
add(panel);

private class taskPerformer implements ActionListener {
    if(captureEvent.getSource() == t) {
        panel.paint(graphic);
        panel.revalidate();
        panel.repaint();
    }
}