protected void doInBackground() throws IOException {
    try {
        // Establish connection
        URL url = new URL(fileUrl);
        HttpURLConnection connection = (HttpURLConnection) url
                .openConnection();
        connection.setDoInput(true);
        connection.connect();
        final String contentLengthStr = connection.getHeaderField("content-length");

        InputStream input = connection.getInputStream();
        String data1 = f.getPath();
        FileOutputStream stream = new FileOutputStream(data1);

        byte data[] = new byte[4096];
        int count;
        int progressCount = 0;

        while ((count = input.read(data)) != -1) {
            stream.write(data, 0, count);
            progressCount = progressCount + count;

            int progress = (int) (((progressCount * 1.0f) / Integer.parseInt(contentLengthStr)) * 10000);

            // Publish your progress here
            publishProgress(progress);
        }

        stream.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}