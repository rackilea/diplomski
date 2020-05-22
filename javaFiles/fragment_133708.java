/**
 * This class represents the super field which contains all single field of the traditional tic tac toe.
 */
class SuperField {

    private static final short SUPER_FIELD_DIMENSION = 3;

    private final Field[][] fields;

    public SuperField() {
        this.fields = new Field[SUPER_FIELD_DIMENSION][SUPER_FIELD_DIMENSION];

        this.init();
    }

    public Field getField(final short field) {
        return this.fields[field / 3][field % 3];
    }

    public void reset() {
        this.init();
    }

    private void init() {
        // Iterate over all rows
        for (short rowIndex = 0; rowIndex < SUPER_FIELD_DIMENSION; ++rowIndex) {
            // Iterate over the columns and set the default field
            for (short columnIndex = 0; columnIndex < SUPER_FIELD_DIMENSION; ++columnIndex) {
                this.fields[rowIndex][columnIndex] = new Field();
            }
        }
    }
}