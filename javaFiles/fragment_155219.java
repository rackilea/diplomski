List<Document> documentList = new ArrayList<>();
MongoCursor<Document> cursor = getCollection(collection).find(Filters.text(entry)).iterator();
while(cursor.hasNext()) {
  Document document = cursor.next();
  documentList.add(document;  
}