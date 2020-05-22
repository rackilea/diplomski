// Declare a ArrayList of Map Objects
    ArrayList<Map<String,Long[]>> mapsList = new ArrayList<>();

    // add all the beans
    mapsList.add(monthMap);
    mapsList.add(monthMap2);
    .
    .


    // declare a map for storing the sum
    Map<String,Long[]> sumMap = new HashMap<>();

    // for every key in map (assuming maps have the same amount 
    // of key-value pairs)
    for(String str : mapsList.get(0).keySet()){
        // initialising sum for long arrays
        Long[] sum = {0L,0L,0L};
        // for every map bean
        for (int i = 0; i < mapsList.size(); i++){
            // for every column in long array of map
            for (int j = 0; j < mapsList.get(i).get(str).length; j++) {
                sum[j] += mapsList.get(i).get(str)[j];
            }
        }
        sumMap.put(str,sum);
    }