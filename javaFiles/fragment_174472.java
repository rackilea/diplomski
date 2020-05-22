new NonStrictExpectations()
    {
            mockedDAO.getSql1(); result = "SQL1";
            mockedDAO.getSql2(); result = "SQL2";

            mockedDAO.getData(anyString);
            result = new mockit.Delegate()
            {
                List<Object> getData(String sql)
                {
                    if (sql.equals("SQL1"))
                        return resultToSql1;
                    if (sql.equals("SQL2"))
                        return resultToSql2;
                    return null;
                }
            }
    };