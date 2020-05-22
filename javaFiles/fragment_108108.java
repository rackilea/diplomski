@Override
protected void initialiseFloorGrid() {
    for (int y = 0; y < nRows + nFirstClassRows; ++y) {
        for (int x = 0; x < nColumns; ++x) {
            //newSeats[y][x].getSeatPosition().setSeatPosition(nRows, (char) ('A' + nColumns));
            newSeats = new Seat[y][x]; 
            newSeats[y][x].setReserved(false);
        }
    }
}