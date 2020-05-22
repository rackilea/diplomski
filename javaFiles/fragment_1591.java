URL url;
    HttpURLConnection urlConnection = null;
    try {
        url = new URL("http://www.mysite.se/index.asp?data=99");

        urlConnection = (HttpURLConnection) url
                .openConnection();

        InputStream in = urlConnection.getInputStream();

        InputStreamReader isw = new InputStreamReader(in);

        int data = isw.read();
        while (data != -1) {
            char current = (char) data;
            data = isw.read();
            System.out.print(current);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (urlConnection != null) {
            urlConnection.disconnect();
        }    
    }