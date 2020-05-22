public List<Model> get(Model model, List<Model> list) 
{
    String query = "{call get(?,?,?,?)}";

    try(Connection con = DBUtil.getConnection(DBType.MYSQL);
        CallableStatement cs = con.prepareCall(query);)
    {
        cs.setInt(1, model.getName());
        cs.setString(2, model.getPosition());
        cs.setString(3, model.getDepartment());
        cs.setString(4, model.getDate());

        try(ResultSet rs = cs.executeQuery())
        {
            while(rs.next())
            {
                Model m = new Model();

                m.setIn(rs.getString(1));
                m.setOut(rs.getString(2));

                list.add(m);

            }
        }
    }
    catch(SQLException ex)
    {
        System.err.println("Error "+ex.getSQLState());
    }
    return list;
}