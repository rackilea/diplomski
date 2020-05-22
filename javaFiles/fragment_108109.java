@Override
protected void initialiseFloorGrid() {
    int xMax = nRows + nFirstClassRows;
    int yMax = nColumns;
    newSeats = new Seat[xMax][yMax];
    for (int x = 0; x < xMax; x++) {
        for (int y = 0; y < yMax; y++) {
            Seat seat = new Seat();
            seat.setReserved(false);
            newSeats[x][y] = seat;
        }
    }
}