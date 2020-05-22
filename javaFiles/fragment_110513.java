String get_dept_list()
{
    trivialFunctions.establishConnection();
    try
    {
        stmt = conn.createStatement();
        sql = "select * from DEPARTMENT_LIST;";
        ResultSet dept_name_list = stmt.executeQuery(sql);
        if(dept_name_list.next())
        {
            String name = dept_name_list.getString("DEPT_NAME");
            return name;
        }
    }
    catch (SQLException e)
    {
        System.out.println("Problem in finding the dept_name_list");
    }
}