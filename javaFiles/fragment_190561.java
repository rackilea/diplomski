Map<String,List<Price>> map = new HashMap();
for (int i=1; i<7; i++) {                                      // attributes 1..7
    String attribute = "attribute" + i;                        // attribute1...attribute7
    options.get(attribute).ifPresent(any ->                    // for non-nulls
               map.put(                                        // put to the map
                   attribute,                                  // attribute as key remains
                   Optional.ofNullable(map.get(attribute))     // gets the existing list
                           .orElse(new ArrayList<>())          // or creates empty
                           .add(price)));                      // adds the current Price
}