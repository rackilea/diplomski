Properties p = myReadProperties();
Set<String> keys = p.keySet();
Set<Integer> serverNumbers = new Set<Integer>();
Iterator<String> i = keys.iterator();
String str, strArray;
while(i.hasNext()) {
  str = i.next();
  //A regex would be better here, but for brevity.
  if(str.startsWith("server.") && str.endsWith(".url")) {
    strArray = str.split(".");
    serverNumbers.add(new Integer(strArray[1]));
  }