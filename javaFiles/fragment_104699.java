protected String sqlInsert = "INSERT INTO categories (title) VALUES (%s) ";
public boolean insert()
{
    String sql = String.format(sqlInsert, this.getTitle());
    return this.RunQuery(sql);
}