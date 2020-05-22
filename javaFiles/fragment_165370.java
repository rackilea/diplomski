public void buyTicket(int id,int n,int price) throws SQLException{
    crs.setCommand("SELECT PAYID FROM PAYMENTINFO WHERE ACCOUNT = '"+account+"'");
    crs.execute();
    crs.next();
    payID = crs.getInt("PAYID");

    try{
    for(int i=0;i<n;i++){

    crs.setCommand("Insert into Tickets (TicketType,EventID,UserID,PayID,Price) values ("+false+","+id+
            ","+ loginBean.getuID() + ","+payID+","+price+")");

    crs.execute();
    crs.next();


    }
    }
    catch(SQLException e){

    System.out.println("  Message:    " + e.getMessage());
    e = e.getNextException();}

    try{
    crs.setCommand("UPDATE EVENTS SET MAXTICKETS = MAXTICKETS - "+n+"WHERE EVENTID = "+id);
    crs.execute();
    crs.next();
    }
    catch(SQLException e ){

    System.out.println("  Message:    " + e.getMessage());
    e = e.getNextException();
    }


}