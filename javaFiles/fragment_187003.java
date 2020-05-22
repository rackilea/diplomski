try {
            Connection conn1 = DriverManager.getConnection("jdbc:postgresql://MYHOST:PORT/?preferQueryMode=simple","USER","PWD");
            Statement stmt = conn1.createStatement();
            String sqlstmt = "select SCHEMA.VIEW.COLUMN1, VSCHEMA.VIEW.COLUMN2, SCHEMA.VIEW.COLUMN3 from SCHEMA.VIEW where SCHEMA.VIEW.COLUMN4 in ('VAL1', 'VAL2', 'VAL3')";
            ResultSet rs = stmt.executeQuery(sqlstmt);
            while(rs.next()){ 
                String c1= rs.getString("COLUMN1"); 
                String c2= rs.getString("COLUMN2");
                System.out.println("COL1:"+c1);
                System.out.println("COL2:"+c2);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }