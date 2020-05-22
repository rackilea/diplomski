// Create the connection where we're going to send the file.
        URL url = new URL(SOAPUrl);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;

        String  postContent = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"+
        "<soap:Header>" +
        "<context xmlns=\"urn:zimbra\">" +
        "<format type=\"js\"/>" +
        "<authToken>" + authToken + "</authToken>" +
        "</context>" +
        "</soap:Header>" +
        "<soap:Body>" + 
        "<GetFolderRequest xmlns=\"urn:zimbraMail\" />" +
        "</soap:Body>" +
        "</soap:Envelope>";

        // insert your SOAP XML!!!
        byte[] b = postContent.getBytes();

        // Set the appropriate HTTP parameters.
        httpConn.setRequestProperty( "Content-Length", String.valueOf( b.length ) );
        httpConn.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
        httpConn.setRequestMethod( "POST" );
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);

        // Everything's set up; send the XML that was read in to b.
        OutputStream out = httpConn.getOutputStream();
        out.write( b );
        out.close();

        // Read the response and write it to standard out.
        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
        BufferedReader in = new BufferedReader(isr);

        // read & do something with input stream...
        String s = null;
        String response = "";
        while((s=in.readLine()) != null){
            response += s;
        }
        in.close();