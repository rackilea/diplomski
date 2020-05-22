Map<String, Number> strToNum = new HashMap<String, Number>();
strToNum.put("one", Integer.valueOf(1));  // OK

Map<String, String> strToStr = new HashMap<String, String>();
strToStr.put("one", "1");  // OK

Map<String, ? extends Object> strToUnk = randomBoolean() ? strToNum : strToStr;
strToUnk.put("null", null);  // OK.  null is an instance of every reference type.
strToUnk.put("two", Integer.valueOf(2));  // NOT OK.  strToUnk might be a string to string map
strToUnk.put("two", "2");  // NOT OK.  strToUnk might be a string to number map