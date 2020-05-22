List<Integer> numbers = mapMap
     .values() //all `Map` values
     .stream()
     .map(Map::values) //map each inner map to the collection of its value
     .flatMap(Collection::stream) // flatten all inner value collections
     .collect(Collectors.toList()); //collect all values into a single list