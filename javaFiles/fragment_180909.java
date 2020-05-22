public static void main(String[] args) throws Exception {
    System.setProperty("VLC_PLUGIN_PATH", "C:\\Program Files\\VideoLAN\\VLC\\plugins");
    File vlcInstallPath = new File("C:\\Program Files\\VideoLAN\\VLC");
    NativeLibrary.addSearchPath(
            RuntimeUtil.getLibVlcLibraryName(), vlcInstallPath.getAbsolutePath());
    Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
    LibXUtil.initialise();

    String[] media = {"C:\\clips\\clip.mp4"};

    //String options = ":sout=#transcode{vcodec=h264,vb=100,venc=x264{profile=baseline},fps=10,width=1920,height=1080,acodec=mp3,ab=24,channels=1,samplerate=44100}:http{mux=ffmpeg{mux=flv},dst=:8090/";
    String options = formatRtspStream("127.0.0.1",8080, "demo");//":sout=#transcode{vcodec=h264,vb=100,venc=x264{profile=baseline},fps=10,width=1920,height=1080,acodec=mp3,ab=24,channels=1,samplerate=44100}:rtp{sdp=rtsp://:8090/}";
    MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory(media);
    HeadlessMediaPlayer mediaPlayer = mediaPlayerFactory.newHeadlessMediaPlayer();
    mediaPlayer.playMedia(media[0],
            options,
            ":no-sout-rtp-sap",
            ":no-sout-standard-sap",
            ":sout-all",
            ":sout-keep"
    );
    Thread.currentThread().join();
}

private static String formatRtspStream(String serverAddress, int serverPort, String id) {
    StringBuilder sb = new StringBuilder(60);
    sb.append(":sout=#rtp{sdp=rtsp://@");
    sb.append(serverAddress);
    sb.append(':');
    sb.append(serverPort);
    sb.append('/');
    sb.append(id);
    sb.append("}");
    return sb.toString();
}