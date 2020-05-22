String dbFileSpec = "C:/Users/Public/example.accdb";
try (Database db = DatabaseBuilder.open(new File(dbFileSpec))) {
    Table tbl = db.getTable("XXXX_XA_Data_1");
    HashMap rowData = new HashMap();
    rowData.put("Today's Future Variation Margin", 1);
    tbl.addRowFromMap(rowData);
}