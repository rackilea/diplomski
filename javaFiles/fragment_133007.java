String sql = "SELECT * FROM DIC";

        rs = st.executeQuery(sql); 

        int rowCount = 0;

        while(rs.next){ 
             rowCount++ 
            if(rowCount == ?) {

                System.out.println("row 1: " + rs.getString("WORD"));  
                System.out.println("row 3: " + rs.getString("WORD"))
             }
        }