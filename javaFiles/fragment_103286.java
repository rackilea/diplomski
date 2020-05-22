Connection cnx = DriverManager.getConnection(sql_auth,login,password); 


sql2 = " SELECT COUNT(*)  CNT FROM ( SELECT UPPER(SOURCECODE)  as SRCCODE
       FROM  T1 WHERE  (PRODUCTTYPE LIKE '%card%') 
       AND ORDER_DATE BETWEEN CONVERT(DATETIME,?) AND   
       CONVERT(DATETIME,?)   
       AND (UPPER(SOURCECODE) IS NOT NULL)  GROUP BY            
       UPPER(SOURCECODE)) AS T";

PreparedStatement ps = cnx.prepareStatement(sql2);

ps.setDate(1, ddet.getStartDate());
ps.setDate(2, ddet.getEndDate());