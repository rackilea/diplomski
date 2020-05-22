ResultSetMetaData metadata = rs.getMetaData();
    int columnCount = metadata.getColumnCount();    
    for (int i = 1; i <= columnCount; i++) {
        writeToFile(metadata.getColumnName(i) + ", ");      
    }
    System.out.println();
    while (rs.next()) {
        String row = "";
        for (int i = 1; i <= columnCount; i++) {
            row += rs.getString(i) + ", ";          
        }
        System.out.println();
        writeToFile(row);

    }