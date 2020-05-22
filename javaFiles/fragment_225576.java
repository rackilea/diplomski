BooleanQuery categoryQuery = new BooleanQuery();
TermQuery catQuery1 = new TermQuery(new Term("category_name", "Electronics"));
TermQuery catQuery2 = new TermQuery(new Term("category_name", "Home"));
categoryQuery.add(new BooleanClause(catQuery1, BooleanClause.Occur.SHOULD));
categoryQuery.add(new BooleanClause(catQuery2, BooleanClause.Occur.SHOULD));
bq.add(new BooleanClause(categoryQuery, BooleanClause.Occur.MUST));