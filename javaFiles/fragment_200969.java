sqlStmt ="SELECT 
                    COLUMN1, 
                    COLUMN2, 
                    COLUMN3, 
                    FROM SAMPLE_TABLE 
                    WHERE 
                    COLUMN1 IN ('10','15') AND 
                    COLUMN3 IN ('1','2') ORDER BY ";            
        try {
            short orderByObj = 0;

            if(orderBy < 1){
                orderByObj = Short.parseShort(Math.abs(orderBy)+"");
                sqlStmt = sqlStmt + " " + orderByObj + " DESC";
            }else{
                sqlStmt = sqlStmt + " " + orderBy ;
            }

            System.out.println("==================== SQL ==================== \n"+sqlStmt);
            ps = conn.prepareStatement(sqlStmt);

            rs = ps.executeQuery();
            while (rs.next())                               
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
        }