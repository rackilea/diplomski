public abstract class Board {
    Collection<Cell> cells;  

    // Don't need to be abstract
    protected void setValues(Collection<Integer> values) {
        Stream<Cell> transformed = values.stream().map(Cell::new);
        cells.addAll(transformed.collect(Collectors.toList()));
    }
}

class Cell {
    private Integer value;

    Cell(Integer value) {
        this.value = value;
    }
}