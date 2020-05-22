String url = "zoyanailpolish.blogspot.com";

    String tld = findTLD( url ); // To be implemented. Add to helper class ?

    url = url.replace( "." + tld,"");  

    int pos = url.lastIndexOf('.');

    String mainDomain = "";

    if (pos > 0 && pos < url.length() - 1) {
        mainDomain = url.substring(pos + 1) + "." + tld;
    }
    // else: Main domain name comes out empty