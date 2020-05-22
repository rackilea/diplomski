// instead of 
// BoundStatement query = prBatchInsert.bind(userId, attributes.values().toArray(new Object[attributes.size()])); 

// try, first combining the uid to the map of values 
Collection<Object> params = new ArrayList<Object>(attributes.size() + 1);
params.add(userId);
for(Object o : attributes.values().toArray())
    params.add(o);

// then passing in the new collection as an array
BoundStatement query = prBatchInsert.bind(params.toArray());