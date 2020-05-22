HashMap<LocalDateTime, HashMap<Object, ArrayList<Object[]>>> map = new HashMap<LocalDateTime, HashMap<Object, ArrayList<Object[]>>>();

    for(int i = 0; i < data.size(); i++) {
        Object[] row = data.get(i);

        int minutes = ((LocalDateTime) row[timeFieldIndex]).getMinute();
        int minutesToAdd = ( newIntervalMinutes - minutes % newIntervalMinutes) % newIntervalMinutes;

        LocalDateTime roundedTime = ((LocalDateTime)row[timeFieldIndex]).plusMinutes(minutesToAdd).withSecond(0);

        HashMap<Object, ArrayList<Object[]>> sortFieldMap = map.get(roundedTime);
        if(sortFieldMap == null) {
            sortFieldMap = new HashMap<Object, ArrayList<Object[]>>();
            map.put(roundedTime, sortFieldMap);
        }

        ArrayList<Object[]> rowList = sortFieldMap.get(row[sortFieldIndex]);
        if(rowList == null) {
            rowList = new ArrayList<Object[]>();
            sortFieldMap.put(row[sortFieldIndex], rowList);
        }

        rowList.add(row);
    }