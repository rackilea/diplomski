StopWatch sw = new StopWatch();
sw.start();
try (Statement st = conn.createStatement()) {
    st.execute("CREATE TABLE zzzTemp (id LONG, val DOUBLE)");
}
double newDbl = ((Long) System.currentTimeMillis()).doubleValue();  // test data
try (PreparedStatement ps = conn.prepareStatement("INSERT INTO zzzTemp (id, val) VALUES (?,?)")) {
    for (int i = 1; i <= 3600; i++) {
        ps.setInt(1, i);
        ps.setDouble(2, newDbl);
        ps.addBatch();
    }
    ps.executeBatch();
}
System.out.printf("Overall elapsed time: %d ms%n", sw.getTime());
try (Statement st = conn.createStatement()) {
    st.execute("MERGE INTO mytab m USING zzzTemp z ON m.id = z.id WHEN MATCHED THEN UPDATE SET m.val = z.val");
    System.out.printf("Overall elapsed time: %d ms%n", sw.getTime());
    st.execute("DROP TABLE zzzTemp");
    System.out.printf("Overall elapsed time: %d ms%n", sw.getTime());
}