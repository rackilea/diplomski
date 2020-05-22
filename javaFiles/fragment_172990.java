public static ResultSet close (ResultSet rs) {
    try {
        if (rs != null)
            rs.close ();
    } catch (SQLException e) {
        e.printStackTrace (); 
        // Or use your favorite logging framework.
        // DO NOT THROW THIS EXCEPTION OR IT WILL
        // HIDE EXCEPTIONS IN THE CALLING METHOD!!
    }
    return null; // Make sure no one uses this anymore
}