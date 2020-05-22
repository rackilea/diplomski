public ReversiPanel() {
    setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
    for (int row = 0; row < GRID_ROWS; row++) {
        for (int col = 0; col < GRID_COLS; col++) {
            panels[row][col] = (new GridPanel(row, col));
            add(panels[row][col]);
            setFocusable(true);
            panels[row][col].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                 ((GridPanel)e.getSource()).getParent().setBackground(Color.red);
                 repaint();
                 }
            });
        }
    }
}