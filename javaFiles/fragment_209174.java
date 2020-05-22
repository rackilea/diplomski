System.out.println("Total number of words in text: " + words.length);

Map<String, Integer> uniqueWordsAndCount = new HashMap<>();
for (String word : words) { 
    if (uniqueWordsAndCount.containsKey(word)){ //If word is in our map already, increase count
        uniqueWordsAndCount.put(word, uniqueWordsAndCount.get(word)+1);
    }else{  //If not in our map, add it and set count to 1
        uniqueWordsAndCount.put(word, 1);
    }
} 
//Accessing the count of a word
uniqueWordsAndCount.get("someWord"); //This returns the count