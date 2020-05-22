@Override
public Collection<Mutation> augment(ByteBuffer key, ColumnFamily update) {
    List<Mutation> mutations = new ArrayList<>(update.getColumnCount());
    String indexKeySpace = properties.getProperty("keyspace");
    String indexColumnFamily = properties.getProperty("table");
    if (!update.deletionInfo().isLive()) {
        CFMetaData cfMetaData = Schema.instance.getCFMetaData(indexKeySpace, indexColumnFamily);
        for (ColumnDefinition columnDefinition : cfMetaData.allColumns()) {
            Mutation mutation = new Mutation(indexKeySpace, key);
            mutation.delete(indexColumnFamily, CellNames.simpleSparse(columnDefinition.name), System.currentTimeMillis());
            mutations.add(mutation);
        }
    }
    return mutations;
}