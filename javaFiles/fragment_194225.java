while(parentOneExchange.contains(newCity)){
    // get the index of the city to replace the repeated city
    arrayIndex = parentOneExchange.indexOf(newCity);
    // get the city that is intended to replace the repeated city
    newCity = parentTwo.get(arrayIndex);
}