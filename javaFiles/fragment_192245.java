QueryParser parser = new QueryParser("field1", analyzer);
java.util.Map boosts = new java.util.HashMap();
boosts.put("field1", new java.lang.Float(1.0));
boosts.put("field2", new java.lang.Float(10.0));

MultiFieldQueryParser multiParser = new MultiFieldQueryParser
                      (new string[] { "field1", "field2" }, analyzer, boosts);
multiParser.setDefaultOperator(QueryParser.Operator.OR);

Query query = multiParser.parse("ABC");
Hits hits = isearcher.search(query);