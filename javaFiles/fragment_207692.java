Object[] dictionaryArray = dictionary.keySet().toArray();
    Arrays.sort(dictionaryArray);

    for(int i = 0; i < dictionaryArray.length; i++){

        String word = (String) dictionaryArray[i];
        dictionary.get(word).SetWordPosition(i);

    }