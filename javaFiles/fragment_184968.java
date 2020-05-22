BooleanQuery query = (BooleanQuery)parser.parse;
BooleanClause[] clauses = query.getClauses();
if (clauses.length == 1 && clauses[0].getOccur() == BooleanClause.Occur.MUST_NOT) {
    booleanQuery.add(clauses[0]);
} else {
    booleanQuery.add(query, BooleanClause.Occur.MUST);
}