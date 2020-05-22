String qry = "select * from register";
PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(qry);
             rs =  stmt.executeQuery();
             while (rs.next()) {
                 String area = rs.getString("city");
                 if(city.equals(area)){
                    System.out.println("!!!!!!It matched: " + city);
                    String state=rs.getString("state");
                    System.out.println("state: " + state);
                    break;
                 } else {
                    //System.out.println("No match with: " + area);
                 }
           }