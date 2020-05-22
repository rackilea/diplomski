List<String> keywords = new ArrayList<>();
keywords.add("/test/");
keywords.add("/demo/");
Document titleRegEx = new Document("$in", keywords);

Document filter = new Document("title", titleRegEx);

Document firstDoc = coll.find(filter).first();