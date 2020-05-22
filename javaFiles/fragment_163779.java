public void addListener(MouseListener listener) {
    cellArray = getCellArray();
    for (int x = 0; x < 10; x++)
        for (int y = 0; y < 10; y++) {
            cellArray[x][y].addMouseListener(listener);
        }
    }
}