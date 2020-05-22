Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3321/database?user=root&password=password");

        Long startTime = System.nanoTime();

        Statement stmt = conn.createStatement();

        StringBuilder stringBuilder = new StringBuilder();

        ResultSet  rs = stmt.executeQuery( "SELECT * FROM contacts" );

        ArrayList<Entity> contacts = new ArrayList<Entity>(rs.getRow());

        while( rs.next() ){
            contacts.add( new Entity( rs.getString("firstname"), rs.getString("lastname") ) );
        }

        for( int i = 0; i < 5; i++ ){
            contacts.forEach( contact -> stringBuilder.append("huzzah ").append(contact.getFirstName()).append(" ").append(contact.getLastName()).append("\n\r"));
        }

        Long endTime = System.nanoTime();
        System.out.print( stringBuilder.toString() );

        Long elapsedTime = ( endTime - startTime );

        double seconds = (double) elapsedTime / 1_000_000_000.0;
        System.out.println( "Total Execution Time: " + seconds );