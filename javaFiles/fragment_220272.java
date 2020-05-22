ResultSet[] result = ((DB2PreparedStatement) preparedStatement).getDBGeneratedKeys();

for (int i = 0; i < result.length; i++) {
    while (result[i].next()) {
        ResultSet rs = result[i];
        java.math.BigDecimal generatedKey = rs.getBigDecimal(1);
        System.out.println("Automatically generated key value = " + generatedKey);
    }
}