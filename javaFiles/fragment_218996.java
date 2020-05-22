public List<Dashboard> getDashboardList(DataSource ds)
{   
    List<Dashboard> list = new ArrayList<Dashboard>();
    Connection con = null;
    PreparedStatement ps = null;
    try
    {
        con = ds.getConnection();
        ps = con.prepareStatement("SELECT * from GLOBALSETTINGS");
        //get customer data from database
        ResultSet result = ps.executeQuery();
        while (result.next())
        {
            Dashboard cust = new Dashboard();
            cust.setUser(result.getString("SessionTTL"));
            cust.setPassword(result.getString("MAXACTIVEUSERS"));
            list.add(cust);
        }
    }
    catch(Exception e1)
    {
        // Log the exception.
    }
    finally
    {
        try
        {
             if(ps != null)
                  ps.close();
             if(con != null)
                  con.close();
        }
        catch(Exception e2)
        {
            // Log the exception.
        }
    }
    return list; 
}