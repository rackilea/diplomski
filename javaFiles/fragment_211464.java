FileItemStream item = iter.next();
if(item.isFormField()) {
   // Normal field
   String name = item.getFieldName();
   String value = Streams.asString(item.openStream());
} else {
   // File
}