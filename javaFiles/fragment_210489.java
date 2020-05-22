Connection connection = null;

try {
    connection = dataSource1.getConnection();
} catch (SQLException e) {
    // handle exception
} finally {
    try {
        connection.close();
    } catch (SQLException e) {
        // handle exception
    }   
}

try {
    connection = dataSource2.getConnection();
    connection.close();
} catch (SQLException e) {
    // handle exception
} finally {
    try {
        connection.close();
    } catch (SQLException e) {
        // handle exception
    }
}