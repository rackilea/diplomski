//Assuming that mVector already holds all you input strings
        Map<String,List<String>> map = new HashMap<String,List<String>>();

        for (String str : mVector){
            List<String> storedList;
            if (map.containsKey(str.substring(0, 1))){
                storedList = map.get(str.substring(0, 1));
            }else{
                storedList = new ArrayList<String>();
                map.put(str.substring(0, 1), storedList);
            }
            storedList.add(str);
        }

        Set<String> unOrdered = map.keySet();
        List<String> orderedIndexes = new ArrayList<String>(unOrdered);
        Collections.sort(orderedIndexes);

        for (String key : orderedIndexes){//get strings for every row
            List<String> values = map.get(key);
            for (String value : values){//writing strings on the same row
                System.out.print(value + "\t"); // change this to writing to some file
            }
            System.out.println(); // add new line at the end of the row
        }