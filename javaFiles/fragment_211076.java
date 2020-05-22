private ResultSetHandler<List<Map<String, Object>>> genericResultHandler()
{
    return new ResultSetHandler<List<Map<String, Object>>>()
    {
        @Override
        public List<Map<String, Object>> handle(java.sql.ResultSet rs) throws SQLException
        {
            List<Map<String, Object>> result = new ArrayList<>();

            // Query all rows of the table.
            while (rs.next())
            {
                // Get metadata of the table.
                java.sql.ResultSetMetaData meta = rs.getMetaData();
                int cols = meta.getColumnCount();
                Map<String, Object> data = new HashMap<>();

                // For each column store column name and value of the cell into the hashmap.
                for (int i = 1; i < cols; i++)
                {
                    String colName = meta.getColumnName(i);
                    Object value = rs.getObject(colName);
                    data.put(colName, value);
                }

                // Add the row to the result list. 
                result.add(data);
            }

            return result;
        }
    };
}