public void randomize(double percent) {
    // No updates while we change state
    setVisible(false);
    for (int r = 0; r < nR; r++) {
        for (int c = 0; c < nC; c++) {
            if (Math.random() < percent / 100)
                grid[r][c].revive();
            else
                grid[r][c].kill(false);
        }
    }
    // Update now
    setVisible(true);
}