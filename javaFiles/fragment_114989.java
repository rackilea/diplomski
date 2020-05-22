map = new HashMap<...>();
    for(int j = 0; j < cellVal.length; j++){ //cellVal - contains value of each cell in a record
        map.put(dataIndexString[j], cellVal[j]);
        System.out.println(j+"--"+dataIndexString[j] + " -- key : value -- "+cellVal[j]);
    }
    items.add(map);