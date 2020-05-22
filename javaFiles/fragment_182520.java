try {
        BufferedReader br = new BufferedReader( new FileReader( new File( "SP500-Weekly.txt"" ) ) );
        List<Double> list = new ArrayList<Double>();
        String line;

        while ( ( line = br.readLine( ) ) != null ) {

            String[] r = line.split( "\\s+" );
            list.add( Double.parseDouble( r[ 1 ] ) );
        }
        br.close( );
        System.out.println( list.size( ) );
    } catch ( IOException io ) {
        e.printStackTrace( );
    }