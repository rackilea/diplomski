this.addMouseListener(new MouseAdapter() {

    @Override
    public void mousePressed(MouseEvent e) {
        currentLine = new Line();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (!currentLine.points.isEmpty()) {
            lines.add(currentLine);
        }
        currentLine = null;
    }
});