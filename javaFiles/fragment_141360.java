try (ResultSet rsMD = connChem.getMetaData().getTables(null, null, null, null)) {
    while (rsMD.next()) {
        String tblName = rsMD.getString("TABLE_NAME");
        System.out.println(tblName);
    }
}