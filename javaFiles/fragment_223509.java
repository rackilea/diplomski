@Test
    public void someTest() throws IOException
    {
        URL u = new URL( "https://ssl.reddit.com/api/login/myusername" );
        login( u, "myusername", "mypassword" );
    }

    public static void login( URL url, String user, String pw ) throws IOException
    {

        String data = "api_type=json&user=" + user + "&passwd=" + pw;
        HttpURLConnection ycConnection = null;
        ycConnection = ( HttpURLConnection ) url.openConnection();
        ycConnection.setRequestMethod( "POST" );
        ycConnection.setDoOutput( true );
        ycConnection.setUseCaches( false );
        ycConnection.setRequestProperty( "Content-Type",
            "application/x-www-form-urlencoded; charset=UTF-8" );
        ycConnection.setRequestProperty( "Content-Length", String.valueOf( data.length() ) );

        DataOutputStream wr = new DataOutputStream(
            ycConnection.getOutputStream() );
        wr.writeBytes( data );
        wr.flush();
        wr.close();
        InputStream is = ycConnection.getInputStream();
        BufferedReader rd = new BufferedReader( new InputStreamReader( is ) );
        String line;
        StringBuffer response = new StringBuffer();
        while ( ( line = rd.readLine() ) != null )
        {
            response.append( line );
            response.append( '\r' );
        }
        for ( Entry< String, List< String >> r : ycConnection.getHeaderFields().entrySet() )
        {
            System.out.println( r.getKey() + ": " + r.getValue() );
        }
        rd.close();
        System.out.println( response.toString() );
    }