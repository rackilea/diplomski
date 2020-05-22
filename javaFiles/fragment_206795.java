BooleanQuery ids = new BooleanQuery();
ids.add(new TermQuery(new Term("id", "6345")), SHOULD);
ids.add(new TermQuery(new Term("id", "5759")), SHOULD);
ids.add(new TermQuery(new Term("id", "333")), SHOULD);

BooleanQuery resultQuery = new BooleanQuery();
resultQuery.add(new PrefixQuery(new Term("description", "blah")), MUST);
resultQuery.add(ids, MUST);