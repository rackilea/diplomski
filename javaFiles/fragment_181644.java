public static String getTheUrlOfHref(String href){
    href = href.replaceAll("^.*?href=\"", "");        // Remove everything before
                                                      // and including href="

    String url = test.substring(0,test.indexOf('"')); // Get everything till
                                                      // first " character
    return url;
}