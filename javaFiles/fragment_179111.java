streamGrabber = new FFmpegFrameGrabber("rtsp://admin:12345@(ip):554/live.sdp");
streamGrabber.setFrameRate(30);
streamGrabber.setImageWidth(getWidth());

try {
    streamGrabber.start();
} catch (FrameGrabber.Exception e) {
    e.printStackTrace();
}