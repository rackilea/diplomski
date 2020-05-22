QueryOptions options = QueryOptions.newBuilder()
     .setLimit(20)
     .setFieldsToSnippet("subject", "body")
     .setScorer(CustomScorer.newBuilder()
         .addSortExpression(SortExpression.newBuilder()
             .setExpression("author")
             .setDirection(SortDirection.DESCENDING)
             .setDefaultValue("")))
     .setCursor(responseCursor)
     .build();
 Query query = Query.newBuilder()
     .setOptions(options)
     .build("good story");