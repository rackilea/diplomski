public static String getPage(String theURL) {

    URL url = null;
    try {
        url = new URL(theURL);
    } catch (MalformedURLException e) {
        e.printStackTrace();
        exitprint();
    }

    for (int i = 0; i < N; i++) {

        try {
            InputStream is = url.openStream();

            int ptr = 0;
            StringBuffer buffer = new StringBuffer();

            while ((ptr = is.read()) != -1)
                buffer.append((char)ptr);

        } catch (IOException e) {
            continue;
        }

        return buffer.toString();
    }

    throw new SomeException("Failed to download after " + N + " attepmts");
}