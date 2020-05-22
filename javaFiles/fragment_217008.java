try
        {
            Connection con;
            Statement st;
            ResultSet rs;

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("Jdbc:Odbc:hos_man");
            st=con.createStatement();
            rs=st.executeQuery("select max(patid) from patient");
            int i=100;
            while (rs.next())
            {
                i=rs.getInt(1);


            }
            textField_1.setText(""+i); 
            con.close();
            st.close();
            rs.close();
        }
        catch (Exception e)
        {
        e.printStackTrace();
        }