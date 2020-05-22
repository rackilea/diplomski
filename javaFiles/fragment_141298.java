Stream<Cell> stream =
        IntStream.range(0, 64)
            .mapToObj(i -> {
                int row = i / 8;
                int column = i % 8;
                return new Cell(row, column, cellBoard[row][column]);
            });