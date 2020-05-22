ArrayList<String> queryResult = new ArrayList<String>();
String query = "0x0640e331";
for(String line : list) {
  if(line.startsWith(query)) {
     queryResult.add(line);
  }
}
return queryResult;