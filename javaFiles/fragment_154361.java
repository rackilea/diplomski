Map<String, List<String>> mapValues = new HashMap<>(25);
List<String> listOfValues = ...;
//...
mapValues.put("A unique key for this list", listOfValues);

//...

List<String> thatListOfValues = mapValues.get("A unique key for this list");