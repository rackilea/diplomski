List<Mutation> mutations = new ArrayList<Mutation>();
Map<String, List<Mutation>> keyMutations = new HashMap<String, List<Mutation>>();
Map<ByteBuffer, Map<String, List<Mutation>>> mutationsMap = new HashMap<ByteBuffer, Map<String, List<Mutation>>>();
try {
    tr.open();
    client.set_keyspace("my_keyspace");

    Deletion deletion = new Deletion();
    SlicePredicate slicePredicate = new SlicePredicate();

    List<ByteBuffer> columns = new ArrayList<ByteBuffer>();

    // Add as many supercolumns as you want here 
    columns.add(toByteBuffer("supercolumn_name"));

    slicePredicate.setColumn_names(columns);
    deletion.setPredicate(slicePredicate);

    // timestamp in microseconds        
    deletion.setTimestamp(System.currentTimeMillis() * 1000);

    Mutation m = new Mutation();
    m.setDeletion(deletion);

    mutations.add(m);

    keyMutations.put("column_family_name", mutations);

    mutationsMap.put(toByteBuffer("row_id_in_column_family"), keyMutations);
    client.batch_mutate(mutationsMap, ConsistencyLevel.ONE);
} catch (Exception e) {
    e.printStackTrace();
} finally {
     tr.flush();
     tr.close();
}