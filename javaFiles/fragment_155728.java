public InputStream getInputStream() throws Exception {
    try {
        process = Runtime.getRuntime().exec("ffmpeg -f dshow -i video=\"" + query + "\":audio=\"" + microPhoneName + "\" -r 25 -vcodec mjpeg -acodec mp3 -f " + getContentExtension() + " -");
        new Thread("Webcam Process ErrorStream Consumer") {
            public void run() {
                InputStream i = process.getErrorStream();
                try {
                    while (!isInterrupted()) {
                        i.read(new byte[bufferLength]);
                    }
                } catch (IOException e) {
                }
            }
        }.start();
    } catch (Exception e) {
    }
    return process.getInputStream();
}