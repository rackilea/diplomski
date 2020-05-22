@Override
public void mousePressed(MouseEvent e) {
    if (selected) {
        return;
    }

    // call the Checkers2 boolean method to check
    if (checkers.isPanelDisabled()) {
        setBackground(DISABLED_COLOR);
    } else {
        setBackground(SELECTED_COLOR);
        setSelected(true);
    }
}