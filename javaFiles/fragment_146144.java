public void randomize(double percent) {
    for (int r = 0; r < nR; r++) {
        for (int c = 0; c < nC; c++) {
            if (Math.random() < percent / 100)
                grid[r][c].revive();
            else
                grid[r][c].kill(false);
        }
    }
    // Force redraw of whole panel
    this.repaint();
}