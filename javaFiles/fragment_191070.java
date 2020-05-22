try (
    Connection conn = DriverManager.getConnection( "jdbc:h2:mem:trashme" )
) {
    String sql = "CREATE TABLE " + "tbl_" + " (\n" +
                     "  uuid_ UUID DEFAULT random_uuid() , \n" +  // Every table should have a primary key.
                     "  when_ DATE \n" +                          // Three columns per the Question.
                     " );";
    try (
        Statement stmt = conn.createStatement() ;
    ) {
        stmt.execute( sql );
    }

    sql = "INSERT INTO tbl_ ( when_ ) VALUES ( ? ) ;";
    LocalDate start = LocalDate.of( 2018 , Month.JANUARY , 23 );
    LocalDate ld = start;  // Keep the `start` object for use later.
    try (
        PreparedStatement ps = conn.prepareStatement( sql )
    ) {
        for ( int i = 1 ; i <= 10 ; i++ ) {
            ps.setObject( 1 , ld );
            ps.executeUpdate();
            // Prepare for next loop.
            int randomNumber = ThreadLocalRandom.current().nextInt( 1 , 5 + 1 ); // Pass minimum & ( maximum + 1 ).
            ld = ld.plusDays( randomNumber ); // Add a few days, an arbitrary number.
        }
    }

    // Dump all rows, to verify our populating of table.
    System.out.println( "Dumping all rows: uuid_ & when_ columns." );
    sql = "SELECT uuid_ , when_ FROM tbl_ ; ";
    int rowCount = 0;
    try (
        Statement stmt = conn.createStatement() ;
        ResultSet rs = stmt.executeQuery( sql ) ;
    ) {
        while ( rs.next() ) {
            rowCount++;
            UUID uuid = rs.getObject( 1 , UUID.class );
            LocalDate localDate = rs.getObject( 2 , LocalDate.class );
            System.out.println( uuid + " " + localDate );
        }
    }
    System.out.println( "Done dumping " + rowCount + " rows." );


    // Dump all rows, to verify our populating of table.
    System.out.println( "Dumping rows where `when_` is after " + start + ": uuid_ & when_ columns." );
    sql = "SELECT uuid_ , when_ FROM tbl_ WHERE when_ > ? ; ";
    rowCount = 0; // Reset count.
    final PreparedStatement ps = conn.prepareStatement( sql );
    ps.setObject( 1 , start );
    try (
        ps ;
        ResultSet rs = ps.executeQuery() ;
    ) {
        while ( rs.next() ) {
            rowCount++;
            UUID uuid = rs.getObject( 1 , UUID.class );
            LocalDate localDate = rs.getObject( 2 , LocalDate.class );
            System.out.println( uuid + " " + localDate );
        }
    }
    System.out.println( "Done dumping " + rowCount + " rows." );

} catch ( SQLException eArg ) {
    eArg.printStackTrace();
}