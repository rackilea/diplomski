PreparedStatement stmt = null;
ResultSet rs = null;

try {
    stmt = connection.prepareStatement(...);
    rs = stmt.executeQuery();
}

// Close your resources in a finally block! Because the finally block
// is executed even if you have exceptions in the try block.
// If you do this a lot of times, write utility methods...
finally {
    try {
        if (rs != null) {
            rs.close();
        }
    } catch (SQLException ignore) {}

    try {
        if (stmt != null) {
            stmt.close();
        }
    } catch (SQLException ignore) {}
}