String query = "MATCH (n:Phone{id:'you'}) MATCH n-[r:calling]->m WHERE n<>m RETURN n, r, m";

ExecutionEngine engine = new ExecutionEngine( db );

ExecutionResult result;
try ( Transaction ignored = db.beginTx() ) {
    result = engine.execute(query);
    ResourceIterator<Relationship> rels = result.columnAs("r");
    while(rels.hasNext()) { 
        Relationship r = rels.next();
        // Do something cool here.
    } 
} catch(Exception exc) { System.err.println("ERHMAGEHRD!!!"); }