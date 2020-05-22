SQL = 
        "SELECT RmID FROM Room " +
        "WHERE " + 
            "RmID NOT IN " +
                "(" +
                    "SELECT RmID FROM Booking " +
                    "WHERE BookDepartureDate > ? AND BookArrivalDate < ? " +
                ")" +
            "AND RmType = ?";
s = conn.prepareStatement(SQL);
s.setDate(1, new java.sql.Date(requestedArrivalDate.toDate().getTime()));
s.setDate(2, new java.sql.Date(requestedDepartureDate.toDate().getTime()));
s.setString(3, "Single");
ResultSet rs = s.executeQuery();