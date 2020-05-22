public void form_test() {
    try {
        url = new URL("http://localhost:9000/resource/frl:6376984/data");
        httpCon = (HttpURLConnection) url.openConnection();
        String userpass = user + ":" + password;
        basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
        httpCon.setRequestProperty("Authorization", basicAuth);
        String fieldName = "data";
        File uploadFile = new File("/home/raul/test/frl%3A6376984/6376990.pdf");
        String boundary = "" + System.currentTimeMillis() + "";

        httpCon.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        httpCon.setRequestProperty("file", "6376986.pdf");

        httpCon.setUseCaches(false);
        httpCon.setDoOutput(true);
        httpCon.setDoInput(true);

        httpCon.setRequestMethod("PUT");

        OutputStream outputStream = null;
        try {
            outputStream = (httpCon.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String LINE_FEED = "\r\n";
        String fileName = uploadFile.getName();
        writer.append("--" + boundary).append(LINE_FEED);
        writer.append("Content-Disposition: form-data; name=\"" + fieldName + "\"; filename=\"" + fileName + "\"")
                .append(LINE_FEED);
        writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
        writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
        System.out.println("Content-Transfer-Encoding: binary" + (LINE_FEED));
        writer.append(LINE_FEED);

        writer.flush();

        fileToOutputStream(uploadFile, outputStream);
        try {
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.append(LINE_FEED);
        writer.flush();
        writer.close();
        httpCon.disconnect();

        try {
            System.out.println(httpCon.getResponseCode());
            System.out.println(httpCon.getResponseMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}