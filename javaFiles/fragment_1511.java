if (person.getNewID ().longValue () == person.getLastPossibleID ().longValue ())
{
    person.setNewID (person.getFirstID ());
}

// add 1 to Old ID to get new ID
syuncronized(this){
person.setNewID (bnkPrb.getNewID + 1);
}


return person;
}