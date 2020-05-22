public class CustomImprovedNamingStrategy extends ImprovedNamingStrategy
{
    @Override
    public String columnName(String columnName)
    {
        return columnName;
    }

    @Override
    public String tableName(String tableName)
    {
        return tableName.replace("tbl_","");
    }
}