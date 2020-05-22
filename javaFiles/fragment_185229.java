public Map<String, List<String>> getFKColumns(Session session, String tableName) {

    Map<String, List<String>> fkMap = new HashMap<String, List<String>>();

    try {
        Connection connection = session.connection();
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet rs = meta.getImportedKeys(connection.getCatalog(), null, tableName);

        while (rs.next()) {

            List<String> fkValues = new ArrayList<String>();
            fkValues.add(rs.getString("PKTABLE_NAME"));
            fkValues.add(rs.getString("PKCOLUMN_NAME"));

            fkMap.put(rs.getString("FKCOLUMN_NAME"), fkValues);
        }

    } catch (HibernateException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return fkMap;
}