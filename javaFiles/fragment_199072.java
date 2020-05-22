private void dbSearch(String ch){
        System.out.println("In dbSearch");
        System.out.println("Concate String :"+ch);
        ch = ch.trim().toString(); // trim and type cast ... its working
        String query = "select * from work_product where product_name ='" + ch + "' ";
        System.out.println("Query is :"+query);
        dbConnector conn = new dbConnector();
        Connection con = conn.dbConnection();
        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2));
            }
        }catch(Exception e){System.out.println(e);}
    }