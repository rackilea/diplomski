String str = inputFile.nextLine();
    String[] parts = str.split(" ");
    for(int x  = 0; x < parts.length; x++)
    {
        String word = parts[x];
       if(word.length() >= 5)
       {
           if(myMap.containsKey(word))
           {
              myMap.put(word, myMap.get(word) + 1);
           }
           else
           {
              myMap.put(word, new Integer(1));
           }
       }
    }