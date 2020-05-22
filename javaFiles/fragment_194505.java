public Booking[] displayAllBookings() throws ClassNotFoundException, SQLException{
        Connection con = connect.getConnection();

        ArrayList<Booking> bookings = new ArrayList<Booking>(); 

        String name = null,surname = null,begindate = null,enddate = null;
        int persons = 0,i=0;

        PreparedStatement posted = (PreparedStatement) con.prepareStatement("SELECT * FROM bookings");
        result = posted.executeQuery();
        while (result.next()){
            begindate = result.getString("begindate");
            enddate = result.getString("enddate");
            name = result.getString("Name");
            surname = result.getString("Surname");
            persons = result.getInt("persons");
            Booking temp =  new Booking(begindate,enddate,name,surname,persons);
            bookings.add(temp);
        }
        return bookings.toArray(new Booking[bookings.size()]);
    }