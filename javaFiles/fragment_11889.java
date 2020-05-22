String str = "AB12TRHW4TR6HH58";

    String[] r = str.split("[a-zA-Z]");
    int sum = 0;
    for ( String s : r ) {
        if ( s.length() > 0 ) {
            sum += Integer.parseInt(s);
        }
    }

    System.out.println(sum);