public void saveToSharedPreferences(Context context, List<String> list){

    Set<String> set =
            list.stream()
            .collect(Collectors.toSet()); // Returns in this case a Set, if you need Iterable or Collection it is also available.

    PreferenceManager.getDefaultSharedPreferences(context) // Get Default preferences, you could use other.
            .edit()
            .putStringSet("myKey", set) // Save the Set of Strings (all trips but as Strings) with the key "myKey", this key is up to you.
            .apply();                   // When possible commit the changes to SharePreferences.
}

public void saveToSharedPreferences(Context context, List<Trip> list){
    List<String> stringList = list.stream()
            .map(Trip::getName) // This uses this method to transform a Trip into a String
                                // you could use other method to transform into String but if all you need to save is the name this suffices
                                // examples: .map( trip -> trip.getName()), .map(trip -> trip.toString()), etc. you choose how to save.
                                // It should save every state that a Trip has, so when you are reading the saved Strings
                                // you will be able to reconstruct a Trip with its state from each String.
            .collect(Collectors.toList());
    saveToSharedPreferences(context, stringList);
}