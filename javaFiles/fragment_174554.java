try{
        stmt = con.createStatement();
        String query = "SELECT MAX(COLUMN_NAME) FROM TABLE_NAME";
        ResultSet rs=stmt.executeQuery(query);          
        //Extact result from ResultSet rs
        while(rs.next()){
            System.out.println("MAX(COLUMN_NAME)="+rs.getInt("MAX(COLUMN_NAME)"));              
          }
        rs.close();
       } catch(SQLException s){                     
            s.printStackTrace();
         }