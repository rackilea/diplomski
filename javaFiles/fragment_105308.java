Session session = contentSource.newSession("mydatabase");
Request request = session.newAdhocQuery(
    "xquery version \"1.0-ml\";\n" +
    "declare variable $myvar as xs:string external;\n" +
    "data($myvar)");

// create Variable "myvar", bind to Request, ignore return value
request.setNewVariable ("myvar", ValueType.XS_STRING, "Some string value");

// "$myvar as xs:string" will be defined at query run time
ResultSequence rs = session.submitRequest(request);