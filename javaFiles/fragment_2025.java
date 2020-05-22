URL url = new URL(getCodeBase(), filename);
    URLConnection urlConnection = url.openConnection();
    BufferedInputStream bufferedInputStream = null;
    try {
        bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
        // ... input data
    } finally {
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
    }