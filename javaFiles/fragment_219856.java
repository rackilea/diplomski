for (HashMap<String, String> hashMap : yourArrayList)
    {
        // For each hashmap, iterate over it
        for (Map.Entry<String, String> entry  : hashMap.entrySet())
        {
           // Do something with your entrySet, for example get the key.
           String sListName = entry.getKey();
        }
    }