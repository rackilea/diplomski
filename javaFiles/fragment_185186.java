String name = airlines                           // take the airlines
    .stream()                                    // stream them
    .filter(a -> a.getName().equals("American")) // take the one(s) with the name "American"
    .findFirst()                                 // get the first one if it's present
    .map(Object::toString)                       // use the toString method for the airline
    .orElse("Airline not found!");               // if no such airline, use this String