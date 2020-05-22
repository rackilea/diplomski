for (Person person : mapOfObjects.values())  //for every person in the map...
{
    int newAmount = 0;
    if (mapOfSum.containsKey(person.getId()))  //if its already in the sumMap
    {
        newAmount = mapOfSum.get(person.getId()) + person.getAmount(); //update the value
    }
    else
    {
        newAmount = person.getAmount();  //else set it as starting value
    }
    mapOfSum.put(person.getId(), newAmount); //put it in the sum map. If it's already there it will be substituted by new entry.
}