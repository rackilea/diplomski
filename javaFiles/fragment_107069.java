Map<String, String> valuesMap = new HashMap<String, String>();
 valuesMap.put("animal", "quick brown fox");
 valuesMap.put("target", "lazy dog");
 String templateString = "The ${animal} jumped over the ${target}.";
 StringSubstitutor sub = new StringSubstitutor(valuesMap);
 String resolvedString = sub.replace(templateString);