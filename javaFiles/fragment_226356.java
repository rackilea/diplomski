Connection conn = null;
    try {
        // get database connection ...

        // do stuff with connection ...
    }
    catch (SQLException e) {
        // handle error connecting to the database or using it
    } 
    finally {
        if (conn != null) {
            try {
                conn.close();
            }
            catch (SQLException e) {
                // handle error disconnecting from the database.
            }
        }
    }