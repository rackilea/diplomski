Mat src = new Mat();
Mat gray = new Mat();
src = Highgui.imread("...");
Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
Core.bitwise_not(gray, gray);
Highgui.imwrite("...", gray);