Scanner s = new Scanner(new File("a.txt")).useDelimiter("\u000C");
    while ( s.hasNext() ) {
        String str = s.next();

        System.out.println( str );
    }