try (Statement s = conn.createStatement()) {
    s.execute("SET PROFILING=1;");
    s.execute("CREATE DATABASE newdb;");
    try (ResultSet rs = s.executeQuery("SHOW PROFILES;")) {
        rs.next();
        System.out.printf(
                "     Statement: %s%nExecution time: %f seconds.%n", 
                rs.getString("Query"), 
                rs.getDouble("Duration"));
    }
    s.execute("SET PROFILING=0;");
}