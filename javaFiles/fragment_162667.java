class CircuitChecker {
    private final Cell[][] circuit;
    private final int nbRows, nbCols;

    public CircuitChecker(Cell[][] circuit) {
        this.circuit = circuit;
        this.nbRows = circuit.length;
        this.nbCols = circuit[0].length;
    }

    public boolean isCircuitComplete() {
        boolean isComplete = true;
        for(int col = 0; col<nbCols; col++) {
            for (int row = 0; row < nbRows; row++) {
                if(cellIsLive(col, row) && !cellHas2LiveConnections(col, row)) {
                    isComplete = false;
                    break;
                }
            }
        }
        return isComplete;
    }

    private boolean cellIsLive(int col, int row) {
        return circuit[row][col].value == 1;
    }

    private boolean cellHas2LiveConnections(int col, int row) {
        Cell left = col > 0 ? circuit[col-1][row] : null;
        Cell right = col < nbCols-1 ? circuit[col+1][row] : null;
        Cell up = row > 0 ? circuit[col][row-1] : null;
        Cell down = row < nbRows-1 ? circuit[col][row+1] : null;

        int nbConnections = Stream.of(left, right, up, down)
                .filter(Objects::nonNull)
                .mapToInt(c -> c.value)
                .sum();
        return nbConnections == 2;
    }
}