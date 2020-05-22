String sql = "select * from TRANSACTION_DUMMY where ID = 'aa' "
            + "and JSON_EXISTS(TRANSACTION_DUMMY_INDEX_FORMAT_JSON, %s)";
// here you could have some code for modifying jsonPathExpression dynamically, 
// e.g. changing the status based on some criteria
String jsonPathExpression = "'$.header.lineItems[*].status?(@==\"complete\")'";

try (Statement st = myConnection.createStatement(String.format(sql, jsonPathExpression))) {

    ResultSet st = ps.executeQuery();
    // Process result set
}