// build the table from mPlatesList
    Set<String> unionSet = new HashSet<String>();
    for (HashMap<String, String> hashMap : mPlatesList) {
        for(String key : hashMap.keySet())
            if(key.equals(TAG_TARGA))
                unionSet.add(hashMap.get(key));
    }
    String[] table = unionSet.toArray(new String[unionSet.size()]);