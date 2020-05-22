/**
 * This class represents a single tic tac toe field.
 */
class Field {

    private static final short FIELD_DIMENSION = 3;

    public static final char EMPTY_FIELD = ' ';
    public static final char PLAYER_ONE = 'x';
    public static final char PLAYER_TOW = 'o';

    private final char[][] cells;

    public Field() {
        this.cells = new char[FIELD_DIMENSION][FIELD_DIMENSION];

        this.init();
    }

    /**
     * Tests a field by given coordinates if a player is present.
     *
     * @param row Given row index of target field
     * @param column Given column index of target field
     * @return True if the move is possible
     */
    public boolean isCellEmpty(final short row, final short column) {

        return Objects.equals(this.cells[row][column], EMPTY_FIELD);
    }

    /**
     * Returns the cell value of a field.
     *
     * @param row Given row index of target field
     * @param column Given column index of target field
     * @return Cell value
     */
    public char getField(final short row, final short column) {
        return this.cells[row][column];
    }

    private void init() {
        // Iterate over all rows
        for (short rowIndex = 0; rowIndex < FIELD_DIMENSION; ++rowIndex) {
            // Iterate over the columns and set the default (or start) value of field
            for (short columnIndex = 0; columnIndex < FIELD_DIMENSION; ++columnIndex) {
                this.cells[rowIndex][columnIndex] = EMPTY_FIELD;
            }
        }
    }
}