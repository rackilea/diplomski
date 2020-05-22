public ArrayList<String> returnMultiples(String[] array, int min){
    HashMap<String, Integer> counts = new HashMap<String, Integer>();//instantiate a new HashMap

    //loop through the array and count the occurrences of each different string in the array
    for(int i = 0; i < array.length; i++){
        String word = array[i];
        if(counts.containsKey(word))
            counts.put(word, counts.get(word) + 1);
        else
            counts.put(word, 1);
    }

    ArrayList<String> multiples = new ArrayList<String>();

    //check if any of the words occur >= min times. if so, add them to the returning list.
    for(String key : counts.keySet()){
        if(counts.get(key) >= min){
            multiples.add(key);
        }
    }

    return multiples;//return the list we just created of the desired strings
}