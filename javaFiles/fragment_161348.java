jdbcTemplate.batchUpdate("INSERT INTO INS_RAZNO.ZAPOSLENICI_TEST VALUES (?, ?, ?, ?, ?, ?)", new BatchPreparedStatementSetter() {
     @Override                                   
     public void setValues(PreparedStatement ps, int i) throws SQLException {
         ps.setString(1, sh.getCell(i,1)); // Iterating over row, getting the first cell
     }
     @Override
     public int getBatchSize() {
         return sheet.getPhysicalNumberOfRows(); // Total rows in the Excel for example
     }
 });