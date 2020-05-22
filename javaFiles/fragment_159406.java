class GetTableNames implements DatabaseMetaDataCallback {

        public Object processMetaData(DatabaseMetaData dbmd) throws SQLException {
            ResultSet rs = dbmd.getTables(dbmd.getUserName(), null, null, new String[]{"TABLE"});
            ArrayList l = new ArrayList();
            while (rs.next()) {
                l.add(rs.getString(3));
            }
            return l;
        }
    }