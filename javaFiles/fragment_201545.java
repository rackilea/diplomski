RestGraphDatabase db= (RestGraphDatabase)Neo4JHelper.getDatabase();
        RestCypherQueryEngine engine=new RestCypherQueryEngine(db.getRestAPI());
        Map<String, Object> params = new HashMap<String, Object>();
        params.put( "id", eventId );
        String query="match (s) where id(s) = {id} return s;";
        QueryResult result=engine.query(query,params);

        if(result.iterator().hasNext()) {

           //HERE PUT WHATEVER YOU NEED
        }