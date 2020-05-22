public class VariableTableEntry {

    private List<Supplier<String>> columnSuppliers;

    public void addColumn(Supplier<String> supplier) {
        columnSuppliers.add(supplier);
    }

    public String getRow() {

        for (Supplier<String> columnSupplier: columnSuppliers) {
            String columnValue = columnSupplier.get();
            // Print each column
        }
    }
}