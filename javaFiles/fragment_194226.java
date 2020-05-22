List<Integer> previous = new ArrayList<>();
while(parentOneExchange.contains(newCity)){
    assert !previous.contains(newCity): previous;
    previous.add(newCity);
    arrayIndex = parentOneExchange.indexOf(newCity);
    newCity = parentTwo.get(arrayIndex);
}