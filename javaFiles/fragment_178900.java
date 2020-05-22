//once the connection has been opened
List values = urlConnection.getHeaderFields().get("content-Length")
if (values != null && !values.isEmpty()) {

    // getHeaderFields() returns a Map with key=(String) header 
    // name, value = List of String values for that header field. 
    // just use the first value here.
    String sLength = (String) values.get(0);

    if (sLength != null) {
       //parse the length into an integer...
       ...
    }