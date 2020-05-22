// …

    HttpURLConnection urlConnection = null;
    try {
        URL url = new URL(request);
        urlConnection = (HttpURLConnection) url.openConnection();

        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        BufferedInputStream bis = new BufferedInputStream(in);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();

        int result = bis.read();
        while(result != -1) {
            buf.write((byte) result);
            result = bis.read();
        }

        String response = buf.toString();

    // …