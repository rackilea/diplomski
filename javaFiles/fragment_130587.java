private String getByPid( int pid ) {
    for ( String line : processes ) {
        if ( line.startsWith( String.valueOf( pid ) ) ) {
            return line;
        }
    }
    return "";
}