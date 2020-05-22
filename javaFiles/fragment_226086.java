BufferedReader reader = null;
    try {
        reader = new BufferedReader( new FileReader( "J:\\questions.txt") );
        String line = null;
        do {
            line = reader.readLine();
            if( line != null ) {
                // Do Something with line                
            }
        } while( line != null );
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if( reader != null )
            try {
                reader.close();
            } catch (IOException e) {
            }
    }