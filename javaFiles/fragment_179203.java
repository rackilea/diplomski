...
    /* Define the data range including headers */
    AreaReference my_data_range = new AreaReference(new CellReference(rowStart, columnStart), new CellReference(areaRow, areaColumn));

    /* Set Range to the Table */
    String wantedDisplayName = "MYTABLE";
    String wantedName = "Test1";
    long id = 0L;

    java.util.List<XSSFTable> all_tables = sheet.getTables();
    for (XSSFTable a_table : all_tables) {
     if (wantedDisplayName.equals(a_table.getDisplayName())) wantedDisplayName += "_1";
     if (wantedName.equals(a_table.getName())) wantedName += "_1";
     if (a_table.getCTTable().getId() > id) id = a_table.getCTTable().getId();

     System.out.println(wantedDisplayName);
     System.out.println(wantedName);
     System.out.println(id);
    }

    id++;

    cttable.setRef(my_data_range.formatAsString());
    cttable.setDisplayName(wantedDisplayName);      /* this is the display name of the table */
    cttable.setName(wantedName);    /* This maps to "displayName" attribute in <table>, OOXML */            
    cttable.setId(id); //id attribute against table as long value
...