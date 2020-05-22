private static final int GRID_WIDTH = 8;
private static final int GRID_HEIGHT = 8;

JFrame whiteFrame = new JFrame();
JFrame blackFrame = new JFrame();

JPanel blackGrid = new JPanel();
JPanel whiteGrid = new JPanel();

JButton[][] whiteTiles = new JButton[GRID_WIDTH][GRID_HEIGHT];
JButton[][] blackTiles = new JButton[GRID_WIDTH][GRID_HEIGHT];
JButton whiteAIButton = new JButton();
JButton blackAIButton = new JButton();

JLabel whiteLabel = new JLabel();
JLabel blackLabel = new JLabel();

public GUI() {
    populateArray(whiteTiles);
    populateArray(blackTiles);

    initGUI();
}

private void populateArray(JButton[][] btnArray) {
    for (int x = 0; x < btnArray.length; x++) {
        for (int y = 0; y < btnArray[0].length; y++) {
            btnArray[x][y] = new JButton();
        }
    }
}

private void initGUI() {
    whiteAIButton.setText("Greedy AI (play white)");
    whiteLabel.setText("White Player - click place to put piece");
    fillGrid(whiteGrid, whiteTiles);

    whiteFrame.setLayout(new BorderLayout());
    whiteFrame.setTitle("Reversi White Player");
    whiteFrame.add(BorderLayout.NORTH, whiteLabel);
    whiteFrame.add(BorderLayout.CENTER, whiteGrid);
    whiteFrame.add(BorderLayout.SOUTH, whiteAIButton);
    whiteFrame.pack();
    whiteFrame.setVisible(true);

    blackAIButton.setText("Greedy AI (play black)");
    blackLabel.setText("Black player - not your turn");
    fillGrid(blackGrid, blackTiles);

    blackFrame.setTitle("Reversi Black Player");
    blackFrame.setLayout(new BorderLayout());
    blackFrame.add(BorderLayout.NORTH, BlackLabel);
    blackFrame.add(BorderLayout.CENTER, blackGrid);
    blackFrame.add(BorderLayout.SOUTH, blackAIButton);
    blackFrame.pack();
    blackFrame.setVisible(true);
}

private void fillGrid(JPanel grid, JButton[][] tiles) {
    grid.setLayout(new GridLayout(GRID_WIDTH, GRID_HEIGHT));

    for (int x = 0; x < GRID_WIDTH; x++) {
        for (int y = 0; y < GRID_HEIGHT; y++) {
            grid.add(tiles[x][y]);
        }
    }
}