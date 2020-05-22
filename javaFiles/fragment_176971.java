public void insertData(int id, String firstName, String lastName)
    {
       if (createConnection()) {
        try
        {
            PreparedStatement ps = con.prepareStatement("INSERT INTO APP.FRIENDS values(?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
[...]