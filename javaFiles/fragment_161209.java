Map<String, List> mapOfLists = new HashMap<String, List>();

mapOfLists.put("strings", listOfStrings);
mapOfLists.put("integers", listOfIntegers);

mapOfLists.get("strings").add("value");
mapOfLists.get("integers").add(new Integer(10));