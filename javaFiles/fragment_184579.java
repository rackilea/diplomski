String strings ="1,2,3,4;5,6,7,8";
    StringTokenizer tok = new StringTokenizer(strings, ";,");
    String[] coordinates = new String[tok.countTokens()];

    int j = 0;
    while (tok.hasMoreTokens()) {
        coordinates[j++] = tok.nextToken();
    }

    System.out.println(Arrays.toString(coordinates));