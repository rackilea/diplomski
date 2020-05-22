while ( ( line = br.readLine( ) ) != null ) {
            String[] r = line.split( "\\s+" );
            for ( String string: r ) {
                if ( string.matches( "^-?[0-9]?.?[0-9]+" ) ) {
                    list.add( Double.parseDouble( r[ 1 ] ) );
                }
            }
        }