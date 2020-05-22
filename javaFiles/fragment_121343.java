Map<String, Number> strToNum = new HashMap<String, Number>();
Map<String, Object> strToObj = new HashMap<String, Object>();

Map<String, ? super Number> strToNumBase;
if (randomBoolean()) {
  strToNumBase = strToNum;
} else {
  strToNumBase = strToObj;
}

// OK.  We know that any subclass of Number can be used as values.
strToNumBase.put("two", Double.valueOf(2.0d));

// But now, gets don't work as well.
Number n = strToNumBase.get("one");  // NOT OK.