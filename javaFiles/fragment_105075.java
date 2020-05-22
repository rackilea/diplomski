GroupByResults<XObject> results = 
    mongoTemplate.group("group_test_collection", 
        GroupBy.key("x")
        .initialDocument("{ count: 0 }")
        .reduceFunction("function(doc, prev) { prev.count += 1 }"), 
    XObject.class);