@Override
public void actionPerformed(ActionEvent event) {
    if (event.getSource() == button) {
        if (red == Color.RED) {
            red = Color.BLACK;
            yellow = Color.YELLOW;
        } else if (yellow == Color.YELLOW) {
            yellow = Color.BLACK;
            orange = Color.ORANGE;
        }
        repaint();
    }
}