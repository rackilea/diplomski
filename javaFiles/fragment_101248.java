public int update(String sqlCommand ){

       int affected_rows = 0;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bankaccount", "root", "password");

            Statement st = (Statement) con.createStatement();                

            affected_rows = st.executeUpdate(sqlCommand);


        } catch (Exception e) {
        }

        return affected_rows;

    }