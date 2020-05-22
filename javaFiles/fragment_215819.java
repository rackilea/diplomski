TermQuery userQuery = new TermQuery(new Term("user_id", u.getId()+""));

BooleanQuery orQuery = new BooleanQuery();
orQuery.add(new BooleanClause(name_query, Occur.SHOULD));
orQuery.add(new BooleanClause(desc_query, Occur.SHOULD));

BooleanQuery andQuery = new BooleanQuery();
andQuery.add(new BooleanClause(userQuery , Occur.MUST));
andQuery.add(new BooleanClause(orQuery, Occur.MUST));