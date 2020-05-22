String queryCheck = "SELECT * from ...";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(queryCheck); // execute the query, and get a java resultset

            if(rs.absolute(1)) {
                //record already exist
            }