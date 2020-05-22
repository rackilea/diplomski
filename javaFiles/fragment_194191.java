public static void main(String[] args) throws Exception
{
     // your VLC installation path
     NativeLibrary.addSearchPath("libvlc", "C:\\Program Files\\VideoLAN\\VLC");

     String media = "your file url"; // example = file:///C:/test.mp4
     // you are gonna use below value on the client 
     String[] options = {":sout=#rtp{sdp=rtsp://localhost:8554/stream"};

     System.out.println("Streaming '" + media + "' to '" + options + "'"); 

     MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory(); 
     HeadlessMediaPlayer mediaPlayer = mediaPlayerFactory.newHeadlessMediaPlayer(); 
     mediaPlayer.playMedia(media, options, ":no-sout-rtp-sap", ":no-sout-standard-sap", ":sout-all", ":sout-keep");

     // Don't exit
     Thread.currentThread().join();
}