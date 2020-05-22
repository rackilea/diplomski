DatastoreService datastore =  DatastoreServiceFactory.getDatastoreService();
Query q = new Query("Users").addFilter("value", Query.FilterOperator.EQUAL, 1);
PreparedQuery pq = datastore.prepare(q);
if(pq!=null) {

    for (com.google.appengine.api.datastore.Entity result : pq.asIterable()) {
        nodeID = result.getProperty("nodeId").toString();
        result.setProperty("value",0);
        datastore.put(result);
        break;

    }
}