Iterator i = droppedFileTarget.entrySet().iterator();

while (i.hasNext()) {
  Map.Entry entry = i.next();
  String extension = (String)entry.getValue();
  String  field = droppedFileTarget.get(extension);  

  params[1]=VKUtils.toExpression(ref, extension);
  params[2]=VKUtils.toExpression(ref, field);
}