public static List<Reservation> checkDatesForReservation(Reservation reservation){
        Reservation reservation = null;
        List<Reservation> reservationList = new ArrayList<>();
        String sql2= "SELECT ReservationStartDate, ReservationEndDate FROM treservations WHERE ReservationStartDate=? AND ReservationEndDate= ?";
        try{
            PreparedStatement ps = ConnectorDB.connection.prepareStatement(sql2);
            ps.setString(1,reservation.getReservationStartDate());
            ps.setString(2,reservation.getReservationEndDate());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
               reservation = new Reservation();
               reservation.setReservationStartDate(rs.getString("ReservationStartDate"));
               reservation.setReservationEndDate(rs.getString("ReservationEndDate"));
               reservationList.add(reservation);
            }
        }catch (SQLException e){
            e.getStackTrace();
        }
        return reservationList;
    }