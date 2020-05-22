public class CellKey {
    final String col;
    final String row;

    private CellKey () {} // no instatiation outside

    public CellKey at(String row, String column) {
        this.col = column;
        this.row = row;
    } 

    public getColumn() {
        return col;
    }

    public getRow() {
        return row;
    }

    public int hashCode() {
        return Objects.hash(col, row);
    }

    public boolean equals(CellKey other) {
        return this.col.equals(other.col) && this.row.equals(other.row);
    }
}