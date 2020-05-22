public class GridWithUnmergedColumnHeaders extends VerticalLayout {

    private static final int INDEX_OF_HEADER = 1;
    private boolean shouldMerge = false;

    public GridWithUnmergedColumnHeaders() {
        // basic grid setup
        Grid grid = new Grid();
        IndexedContainer container = new IndexedContainer();
        grid.setContainerDataSource(container);
        container.addContainerProperty("name", String.class, "");
        container.addContainerProperty("surname", String.class, "");
        container.addContainerProperty("age", Integer.class, 0);

        grid.addRow("Some", "One", 20);
        grid.addRow("Someone", "Else", 50);

        grid.addHeaderRowAt(INDEX_OF_HEADER).join("name", "surname").setText("Whatever");

        // button to toggle properties
        Button button = new Button("Toggle header merging", event -> {
            if (shouldMerge) {
                grid.removeHeaderRow(INDEX_OF_HEADER);
                grid.addHeaderRowAt(INDEX_OF_HEADER).join("name", "surname").setText("Whatever");
            } else {
                grid.removeHeaderRow(INDEX_OF_HEADER);
                Grid.HeaderRow headerRow = grid.addHeaderRowAt(INDEX_OF_HEADER);
                headerRow.getCell("name").setText("What");
                headerRow.getCell("surname").setText("Ever");
            }
            shouldMerge = !shouldMerge;
        });

        addComponents(grid, button);
    }
}