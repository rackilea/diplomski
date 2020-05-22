URLConnection connection = new URL("your url").openConnection();

// insert auth parameters and set method to post
// call doInput, doOutput on connection
// read cookie

    List<String> cookies = connection.getHeaderFields().get("Set-Cookie");
    myCookie = you need to change cookies list to one String containing all cookies, i don't have this code right now, but is should be easy.
    URLConnection resourceCon = new URL("your url").openConnection();
    resourceCon.setRequestProperty("Cookie", myCookie);