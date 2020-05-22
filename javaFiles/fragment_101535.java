List<String> names = ...;
try ( Transaction tx = graphDb.beginTx() )
{
    String queryString = "UNWIND {names} AS name CREATE (n:User {name: name})";
    Map<String, Object> parameters = new HashMap<>();
    parameters.put( "names", names );
    graphDb.execute( queryString, parameters );
    tx.success();
}