// start connection
    List<SomeBean> v = new ArrayList<SomeBean>();
    Statement st;
    try 
    {
        st = conn.createStatement();

        ResultSet rs = st.executeQuery(sql);        
        while( rs.next() ){             

                SomeBean n = new SomeBean();
                n.setFirstField(rs.getInt("firstfield"));
                n.setSecondField(rs.getString("secondfield"));

                ...
                ...

                v.add(n);
        }
    } 
    catch (SQLException e) 
    {
        e.printStackTrace();
    }

    // close connection