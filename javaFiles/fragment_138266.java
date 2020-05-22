AccessToken accessToken = AccessToken.getCurrentAccessToken();
    GraphRequest request = GraphRequest.newPostRequest(accessToken, "me/videos", null, callback);
    Bundle params = request.getParameters();
    try {
        byte[] data = readBytes(videoPath);
        params.putByteArray("video.mp4", data);
        params.putString("title", albumName);
        params.putString("description", " #SomeTag");
        request.setParameters(params);
        request.executeAsync();
    }
    catch (Exception e) {
        e.printStackTrace();
    }


    public byte[] readBytes(String dataPath) throws IOException {

        InputStream inputStream = new FileInputStream(dataPath);
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];

        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }

        return byteBuffer.toByteArray();
    }