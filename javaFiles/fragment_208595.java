public static List<String> getColumnNames(String tableName) {

    List<String> columnList = new ArrayList<>();

    for (Namespace namespace : MetadataExtractorIntegrator.INSTANCE.getDatabase().getNamespaces()) {
        for (Table table : namespace.getTables()) {
            if (table.getName().equalsIgnoreCase(lookupTableName)) {
                Iterator<Column> iterator = table.getColumnIterator();
                while (iterator.hasNext()) {
                    columnList.add(iterator.next().getName());
                }
                break;
            }
        }
        if (!columnList.isEmpty())
            break;
    }
    return columnList;
}