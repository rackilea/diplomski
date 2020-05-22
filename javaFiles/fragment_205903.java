Set<TokenRange> tokenRanges = cassandraSession.getCluster().getMetadata().getTokenRanges();

for(TokenRange tr: tokenRanges) {
    List<Row> rows = new ArrayList<>();
    for(TokenRange sub: tr.unwrap()){
        String query = "SELECT * FROM keyspace.table WHERE token(pk) > ? AND token(pk) <= ?";
        SimpleStatement st = new SimpleStatement( query, sub.getStart(), sub.getEnd() );
        rows.addAll( session.execute( st ).all() );
    }
    transformAndWriteToNewTable(rows); 
}