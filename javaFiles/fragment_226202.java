QueryBuilder query = new QueryBuilder();
query.put("loc").near(-122.934326171875, 37.795268017578, 50);
query.or(
        QueryBuilder.start("uid").is("at").get(),
        QueryBuilder.start("myList.$id").is(new ObjectId("5024f2f577a59dd9736ddc38")).get()
            );
query.put("searchTag").regex(Pattern.compile("Union",Pattern.CASE_INSENSITIVE));