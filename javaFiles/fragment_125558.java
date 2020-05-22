// Procedure call.
CallableStatement proc = conn.prepareCall("{ ? = call refcursorfunc() }");
proc.registerOutParameter(1, Types.OTHER);
proc.execute();
ResultSet results = (ResultSet) proc.getObject(1);
while (results.next()) {
    // read results
}
results.close();
proc.close();