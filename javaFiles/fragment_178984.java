import org.opencv.core.Core;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

byte[] screenshotByte = ((TakesScreenshot)context).getScreenshotAs(OutputType.BYTES))
byte[] subImgToFindByte = DatatypeConverter.parseBase64Binary(imageBase64String)

System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
Mat source = Imgcodecs.imdecode(new MatOfByte(screenshotByte), Imgcodecs.IMREAD_UNCHANGED);
Mat template = Imgcodecs.imdecode(new MatOfByte(subImgToFindByte), Imgcodecs.IMREAD_UNCHANGED);

int result_cols = source.cols() - template.cols() + 1;
int result_rows = source.rows() - template.rows() + 1;
Mat outputImage = new Mat(result_rows, result_cols, CvType.CV_32FC1);

// Template matching method
Imgproc.matchTemplate(source, template, outputImage, Imgproc.TM_SQDIFF_NORMED);

MinMaxLocResult mmr = Core.minMaxLoc(outputImage);
// Now get the point
Point point = mmr.minLoc;
double x = point.x;
double y = point.y;

//Now get the find the element using x, y after calculating center point.
int centerX = int(x + (bufferedSubImgToFind.getWidth() / 2));
int centerY = int(y + (bufferedSubImgToFind.getHeight() / 2));

WebElement el = js.executeScript("return document.elementFromPoint(arguments[0], arguments[1]);", centerX, centerY);