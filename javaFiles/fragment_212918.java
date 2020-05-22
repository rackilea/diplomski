try ( Transaction tx = database.beginTx()) {
    String query = "MATCH (n:KISI) where id(n)=1 return n";
    // use result with try-with-resource to ensure that it will be closed
    try(Result result = database.execute(query)) {
        // do stuff you need with result here
        return Response.ok("nodeId =" + nodeId).build();
    }

    tx.success(); // mark transaction as successful 
} catch (Exception e) {
    // If exception occurs - send exception message with 500 status code
    // It's good idea to write Exception stacktrace to log there
    return Response.serverError().entity(e.getMessage()).build()      
}