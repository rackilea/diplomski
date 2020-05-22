public static void main(String[] args) throws Exception {

OpenCVFrameGrabber grabber = new OpenCVFrameGrabber("http://USER:PASSWORD@187.45.142.127:80/mjpeg.cgi?user=USER&password=PASSWORD&channel=0&.mjpg"); 
grabber.setFormat("mjpeg");
grabber.start();

IplImage frame = grabber.grab();
CanvasFrame canvasFrame = new CanvasFrame("Camera");
canvasFrame.setCanvasSize(frame.width(), frame.height());
while (canvasFrame.isVisible() && (frame = grabber.grab()) != null) {
    canvasFrame.showImage(frame);
}
grabber.stop();
canvasFrame.dispose();
System.exit(0);