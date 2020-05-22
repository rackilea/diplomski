/** Formats the value in a column containing Date objects. */
class DateColumnGenerator implements Table.ColumnGenerator {
    String format; /* Format string for the Date values. */

    /**
     * Creates date value column formatter with the given
     * format string.
     */
    public DateColumnGenerator(String format) {
        this.format = format;
    }

    /**
     * Generates the cell containing the Double value.
     * The column is irrelevant in this use case.
     */
    public Component generateCell(Table source, Object itemId,
                                  Object columnId) {
        // Get the object stored in the cell as a property
        Property prop =
            source.getItem(itemId).getItemProperty(columnId);
        if (prop.getType().equals(Date.class)) {
            Label label = new Label(.......);
            return label;
        }
        return null;
    }
}