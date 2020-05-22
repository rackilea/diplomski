private void handleClick(JButton[][] bGrid, int gridy, int gridx, int y, int x, bool realClick) {
    if (x < 0 || x >= gridx || y < 0 || y >= gridx) {
        return;
    }

    JButton button = bGrid[y][x];
    if (!button.isEnabled()) {
        return;
    }

    if (realClick) {
        --clicked;
    }

    button.setBackground(lighterGray);
    button.setEnabled(false);

    if (...is a mine...) {
        ...
    } else {
        button.setText(array[y][x]);

        if (value == 0) {
            handleClick(bGrid, gridy, gridx, y-1, x-1, false);
            handleClick(bGrid, gridy, gridx, y-1, x,   false);
            handleClick(bGrid, gridy, gridx, y-1, x+1, false);
            handleClick(bGrid, gridy, gridx, y,   x-1, false);
            handleClick(bGrid, gridy, gridx, y,   x+1, false);
            handleClick(bGrid, gridy, gridx, y+1, x-1, false);
            handleClick(bGrid, gridy, gridx, y+1, x,   false);
            handleClick(bGrid, gridy, gridx, y+1, x+1, false);
        }
    }
}