**StringJoiner joiner2 = new StringJoiner(",", "(", ")");**
while (mapIterator.hasNext()) {

 //change in value1 as
value = "\"" + (String) mapEntry.getValue() +  "\"";
 value1 = joiner2.add(value);
 myvalue = joiner2.add("?");