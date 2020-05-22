try {
        Connection con = null;
        ResultSet rs;
    con=DB.getConnection();


       // this fire returns as an Integer 4
        PreparedStatement ps =con.prepareStatement("SELECT EXTRACT
(EPOCH FROM(last_reply-created_on)/60):: integer as fire from streams where id=65");
        rs= ps.executeQuery();


        while (rs.next()) {
         // I then put this method through
            System.err.println(difference(rs.getInt("fire")));
        }
        con.close();
        return ok();
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }
private static String difference(Integer i) {
String id="";
    if(i<60)
    {
     4 is obviously less than 60 but it is not working
        id= i+ " min";
    }else if(i>=60 && i<1440)
    {
        id=i+ " hrs";
    }else if(i>=1441 && i<10080)
    {
        id=i+" days";
    }
    else
    {
        id=i+" weeks";
    }
// returns as 4 date
    return id;
}