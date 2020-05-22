Connection conn = mysqlconn.getConnection();
conn.setAutoCommit(false); // here

PreparedStatement ps = null;

String query = "insert into table (column) values (?)";

System.out.println("bulk insert started with "+10000 );
long startTime = System.currentTimeMillis();

try {
    ps = conn.prepareStatement(query);
    long start = System.currentTimeMillis();
    for(int i =0; i<10000;i++){

        ps.setString(1, "Name"+i);

        ps.addBatch();

        if(i%1000 == 0) {
            ps.executeBatch();
            conn.commit(); // here
        }
    }
    ps.executeBatch();
    conn.commit(); // here

    System.out.println("Time Taken="+(System.currentTimeMillis()-start));

} catch (SQLException e) {
    e.printStackTrace();
}