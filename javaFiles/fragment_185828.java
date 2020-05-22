ArrayList entryList = loadEntries(entries);
    int[] colIndx = new int[entryList.size()];
    ResultSetMetaData rsmd = rs.getMetaData();
    int numberOfColumns = rsmd.getColumnCount();
    for (int i = 0; i < entryList.size(); i++){
       Entry e = (Entry) entryList.get(i);
       for (int j = 1; j <= numberOfColumns; j++){
          if(rsmd.getColumnName(j).equalsIgnoreCase(e.getColumn()))
              colIndx[i] = j;
       }
    }
    try{
        while (rs.next()){
            for (int i = 0; i < colIndx.length ; i++){
                System.out.println("Column Values["+colIndx[i]+"] : "+rs.getString(colIndx[i]));
            }
        }
    }