conn.prepareStatement(""
        + "UPDATE SEAT"
        + "SET reserved='1337',booked='1337',booking_time='1337'"
        + "WHERE plane_no='" + plane_no + "';"
);
conn.commit();