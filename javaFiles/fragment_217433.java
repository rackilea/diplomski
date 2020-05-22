try (InputStream is = new URL("http://textfiles.com/100/914bbs.txt").openStream();
     OutputStream os = response.getOutputStream()) {

    int read = 0;
    byte[] bytes = new byte[BYTES_DOWNLOAD];

    while ((read = is.read(bytes)) != -1) {
        os.write(bytes, 0, read);
    }
    os.flush();
}