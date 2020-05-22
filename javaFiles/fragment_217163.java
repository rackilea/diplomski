Query<DocumentKeywords> query = ofy.query(DocumentKeywords.class);
  for (String keyword : keywords) {
    query = query.filter("keywords", keyword);
  }

  Set<Key<Document>> keys = query.<Document>fetchParentKeys();

  Collection<Document> documents = ofy.get(keys).values();