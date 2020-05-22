String[] lines = everyLine.split("\\n");
    String[][] proxies = new String[lines.length][];
    int i=0;
    for ( String line : lines )
    {
        proxies[i++] = line.split(":");
    }