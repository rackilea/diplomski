
  Map map = new LinkedHashMap();
  map.put("2", "String(2)");
  map.put(new Integer(2), "Integer(2)");
  map.put(new Long(2), "Long(2)");
  map.put(42, "AutoBoxedNumber");

  pageContext.setAttribute("myMap", map);  
  Integer lifeInteger = new Integer(42);
  Long lifeLong = new Long(42);  
