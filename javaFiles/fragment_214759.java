Optional<String> myFutureProp =
    aList.stream()
         .flatMap(a->a.getElements().stream().map(B::getProperty))
         .filter(prop->prop.getKey().equals("MY_PROPERTY"))
         .map(Property::getValue)
         .findAny();