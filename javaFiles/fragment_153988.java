grid = new JPanel[rows][cols];
MyMouse myMouse = new MyMouse();
for (int r = 0; r < grid.length; r++) {
    for (int c = 0; c < grid[r].length; c++) {
        grid[r][c] = new JPanel();
        grid[r][c].setOpaque(true);
        Color color = data[r][c] == 0 ? Color.WHITE : Color.DARK_GRAY;
        grid[r][c].setBackground(color);
        grid[r][c].setPreferredSize(new Dimension(ICON_W, ICON_W));
        grid[r][c].addMouseListener(myMouse); // ***** here, add the listener)
        add(grid[r][c]);

    }
}