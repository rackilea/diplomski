public void mouseEntered(MouseEvent e) {
    if (bakery.getBackground() != Color.YELLOW) { // skip if already yellow
        bakery.setBackground(Color.GREEN);
    }
}

public void mouseExited(MouseEvent e) {
    if (bakery.getBackground() != Color.YELLOW) { // skip if already yellow
        bakery.setBackground(UIManager.getColor("control"));
    }
}

public void mousePressed(MouseEvent e) {
    if (bakery.getBackground() != Color.YELLOW) {
        // The first click will set yellow
        bakery.setBackground(Color.YELLOW);
    } else {
        // A second click clears the yellow.
        bakery.setBackground(UIManager.getColor("control"));
    }
}