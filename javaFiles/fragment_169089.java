public static String fmtURL(String relpath) {
    String url = relparth.startsWith( "_sec" ) ? "https://":"http://";
    url += hostname;                        // from a configfile
    if ( relparth.startsWith( "_sec" ) {
        url += ":443";
    }
    url += relpath;
    return url;
}