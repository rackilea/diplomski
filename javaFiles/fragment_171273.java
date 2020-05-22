if (records.size() > 0) {               
        for (Integer record: records) {
            dateMap.get(Integer.parseInt(record));  //you can remove this line
            dateMap.put(record,new ArrayList(resultDate));
        }
    }