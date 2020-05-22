TableView<FirstTablesData> firstTable = new TableView<>();

// create a list that holds the original order of the columns:
List<TableColumn<FirstTablesData, ?>> firstTableOriginalColumns = new ArrayList<>(...);

firstTable.getColumns().setAll(firstTableOriginalColumns);

// same for second table:

TableView<SecondTablesData> secondTable = new TableView<>();
List<TableColumn<SecondTablesData, ?>> secondTableOriginalColumns = new ArrayList<>(...);
secondTable.getColumns().setAll(secondTableOriginalColumns);

firstTable.getColumns().addListener((Change<? extends TableColumn<FirstTablesData,?>> change) -> 
    secondTable.getColumns().setAll(firstTable.getColumns().stream()
        .mapToInt(firstTableOriginalColumns::indexOf)
        .mapToObj(secondTableOriginalColumns::get)
        .collect(Collectors.toList())));