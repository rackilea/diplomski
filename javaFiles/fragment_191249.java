InputStream is;    
if (conn.getResponseCode() / 100 == 2) { // HTTP status code 2xx, e.g. 200
    is = conn.getInputStream();

    // read input stream -> this is the content you wanted

} else {
    is = conn.getErrorStream();

    // read input stream -> contains a description of the error
    // depending on header "Content-Type" you can also parse the stream
    // as JSON or XML or HTML ...

}