public class MyFunkyDao extends SqlMapClientDaoSupport
{
    private static final int DB_BATCH_SIZE = 1000;

    public void storeMyData(final List<MyData> listData)
    {
        getSqlMapClientTemplate().execute( new SqlMapClientCallback()
        {
            @Override
            public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException
            {
                int count = 0, total = 0;

                Map<String, Object> params = new HashMap<String, Object>();

                executor.startBatch();

                for (MyData data: listData)
                {
                    params.put("param name 1", data.getValue());

                    executor.insert("insertData", params);

                    count++;
                    if (count % DB_BATCH_SIZE == 0) 
                    {
                        total += executor.executeBatch();
                        executor.startBatch();
                    }

                    params.clear();
                }

                total += executor.executeBatch();

                return new Integer(total);
            }
        });
    }
}