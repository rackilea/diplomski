ComplexKey keys = ComplexKey.of(“93”,”23”);
ViewQuery q = createQuery("getProfileInfo").descending(true).key(keys).includeDocs(true); 
ViewResult vr = db.queryView(q); 
List<Row> rows = vr.getRows(); 
for (Row row : rows) { 
  System.out.println("Key--->"+row.getKey()); 
  System.out.println("Value--->"+row.getValue()); 
}