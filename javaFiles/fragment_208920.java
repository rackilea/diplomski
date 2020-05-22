public Room(int guestsID)
{
    this();
    try{
        // This line looks wrong, shouldn't this be selecting from the
        // room table??
        // statement = con.prepareStatement("SELECT * FROM room WHERE guestID=?");
        // instead???
        statement = con.prepareStatement("SELECT * FROM guest WHERE guestID=?");
        statement.setInt(1, guestID);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            this.guestID = rs.getInt(1);
            this.roomType = rs.getString(2);
            this.roomNo = rs.getInt(3);
        }
    }catch(Exception e){
        System.out.print(e);
    }
}