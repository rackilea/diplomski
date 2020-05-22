tableData = new ArrayList< Map<String, ColumnModel> >();
    tableHeaderNames = new ArrayList<ColumnModel>();
    Statement SQL = dbConnectionSQLServer.getCN().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

    RS = SQL.executeQuery("Select * From Coa32");

    for (int j = 0; j < RS.getMetaData().getColumnCount(); j++) {
    System.out.println("Start:");
        tableHeaderNames.add(new ColumnModel("header "+j, " col:"+ RS.getMetaData().getColumnLabel(1)));
    System.out.println("End:");
    }