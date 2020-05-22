while(it.hasNext()) {
  Document nextDocument = (Document) it.next();
  StringBuilder builder = new StringBuilder();
  builder.append(nextDocument.getString("_id")).append(nextDocument.getString("Name")).append(nextDocument.getString("Contact")); 
  mongoArrayList.add(builder.toString()); 
}