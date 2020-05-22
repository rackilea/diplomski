numberOfColumns = rsMD.getColumnCount();
   ColumnNames = new String[numberOfColumns+1];
    System.out.println(""+numberOfColumns);

    for(int i=1;i<=numberOfColumns;i++)
    {
        String colName=rsMD.getColumnName(i);
        ColumnNames[i] = colName;
        System.out.println(""+ColumnNames[i]);
    }