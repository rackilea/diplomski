public boolean isVideoFile(String path) {
        String mimeType = URLConnection.guessContentTypeFromName(path);
        System.out.println(mimeType);
        return mimeType != null && mimeType.indexOf("video") == 0;

  }