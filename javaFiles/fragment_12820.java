public boolean deleteEntity(String propertyValue) {
    String entityName = "YOUR_ENTITY_NAME";
    String gql = "SELECT * FROM "+entityName +" WHERE property= "+propertyValue+"";
    Query<Entity> query = Query.newGqlQueryBuilder(Query.ResultType.ENTITY, gql)
            .setAllowLiteral(true).build();
    try{
        QueryResults<Entity> results = ds.run(query);           
        if (results.hasNext()) {
            Entity rs = results.next();             
            ds.delete(rs.getKey());
            return true;
        }
        return false;
    }catch(Exception e){
        logger.error(e.getMessage());
        return false;
    }
}