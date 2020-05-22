ParsedOperation operation = QueryParserUtil.parseOperation(QueryLanguage.SPARQL, qb, null); 
if (operation instanceof ParsedTupleQuery) {
   ParsedTupleQuery q = (ParsedTupleQuery)operation;
   ...
} else if (operation instanceof ParsedGraphQuery) {
   ParsedGraphQuery q = (ParsedGraphQuery)operation;
   ...
} else if (operation instance ParsedUpdate) {
   ParsedUpdate u = (ParsedUpdate)operation;
   ...
}