Map<String,Object> dataDictionary = new LinkedHashMap<>();
dataDictionary.put("industryCodes", null);
dataDictionary.put("regionCodes", "test");
dataDictionary.put("omitKeywords", null);
dataDictionary.put("resultsPerPage", 21);
dataDictionary.values().removeIf(Objects::isNull);
System.out.println(dataDictionary);