private static class ButtonMouseListener extends MouseAdapter {
    private final int x;
    private final int y;

    public ButtonMouseListener(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            JOptionPane.showMessageDialog(null, "Left -> " + x + " | " + y);
        }  else if (e.getButton() == MouseEvent.BUTTON3) {
            JOptionPane.showMessageDialog(null, "Right -> " + x + " | " + y);
        }
    }
}