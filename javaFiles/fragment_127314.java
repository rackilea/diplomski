Date startDate = (Date) data.get("startDate");//2014-04-01  
Date endDate = (Date) data.get("endDate");//2014-04-30
int pagesize=10;

String query = "select * from bill_details "
                + " where status=? "
                + " AND date(add_date) BETWEEN  ? AND ?"
                + " order by add_date  desc limit ?";

    ps = con.prepareStatement(query);
    ps.setString(1, dataStatus);
    ps.setDate(2, startDate);
    ps.setDate(3, endDate);
    ps.setInt(4, pagesize);
    System.out.println("Before execution");
    res = ps.executeQuery();