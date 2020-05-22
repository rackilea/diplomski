Query query = new SpanNearQuery(new SpanQuery[] {
         new SpanTermQuery(new Term("title", "convert")),
         new SpanMultiTermQueryWrapper(new PrefixQuery(new Term("title", "int"))),
         new SpanTermQuery(new Term("title", "string"))
     },
     50,
     true);
return query;