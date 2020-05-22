class queries
{
    public static String getQuery1(String tableName)
    {
        return "Select * from "+tableName;
    }

    public static String getQuery2(String tableName, String columnName)
    {
        return "Select "+columnName+" from "+tableName;
    }
}