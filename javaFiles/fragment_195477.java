JButton[][] buttonGrid = new JButton[10][14];
for (int y = 0; y < 10; y++) {
    for (int x = 0; x < 14; x++) {
        buttonGrid[y][x] = new JButton("Test");
        if (y == 0) {
            // code in here is only executed for the first row
            buttonGrid[y][x].setText(Integer.toString(x));
        }
        if (x == 0) {
            // code in here is only executed for the first column
            buttonGrid[y][x].setText(Integer.toString(y));
        }
    }
}