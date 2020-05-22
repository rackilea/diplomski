public String book(int plotNo) throws SQLException
{
    ...

    try
    {
        int newBookingNo = generateBookingNo();
        setBookingNo(newBookingNo);        
        String updateTableSQL = "UPDATE PLOT SET BOOKINGNO = ? WHERE PLOTNO = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateTableSQL);
        preparedStatement.setInt(1, getBookingNo());
        preparedStatement.setInt(2, plotNo);
        preparedStatement.executeUpdate();    
        return "ConfirmBooking"; // go to ConfirmBooking.xhtml page
    } // end try
    finally
    {
        connection.close(); // return this connection to pool
    } // end finally
} // end method book