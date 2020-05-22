for (String word : list) {                 //For every word in list,
    Integer previousAmount = map.get(word);    //Get the current count and store it.
    if(previousAmount == null)             //If the count doesn't exist (null, not in map),
        map.put(word, 1);                  //Put 1 in the map (first time.)
    else                                   //Otherwise (in the map)
        map.put(word, previousAmount + 1); //Add one to the current amount
}