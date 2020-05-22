oracle.sql.ARRAY result2 = (oracle.sql.ARRAY) stmt.getObject(2);
ResultSet rs = result2.getResultSet();
oracle.sql.STRUCT elements = (oracle.sql.STRUCT) rs.getObject(2);
String result = null;
if (elements != null) {
    Object[] objs = elements.getAttributes();
    result = objs[2];
}
System.out.println("Result: " + result);