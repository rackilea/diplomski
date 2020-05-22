public class RunTest1
{   
  public static void main(String args[])
  { 

    IplImage src = cvLoadImage("C:\\Users\\Nespresso\\Desktop\\cervelo.jpg",0);
    IplImage tmp = cvLoadImage("C:\\Users\\Nespresso\\Desktop\\subImage.jpg",0);    

    IplImage result = cvCreateImage(cvSize(src.width()-tmp.width()+1, src.height()-tmp.height()+1), IPL_DEPTH_32F, 1);
    cvZero(result);

    //Match Template Function from OpenCV
    cvMatchTemplate(src, tmp, result, CV_TM_CCORR_NORMED);

    double[] min_val = new double[2];
    double[] max_val = new double[2];

    CvPoint minLoc = new CvPoint();
    CvPoint maxLoc = new CvPoint();

    //Get the Max or Min Correlation Value      
    cvMinMaxLoc(result, min_val, max_val, minLoc, maxLoc, null);

    System.out.println(Arrays.toString(min_val));
    System.out.println(Arrays.toString(max_val));

    CvPoint point = new CvPoint();
    point.x(maxLoc.x()+tmp.width());
    point.y(maxLoc.y()+tmp.height());

    cvRectangle(src, maxLoc, point, CvScalar.WHITE, 2, 8, 0);//Draw a Rectangle for Matched Region

    cvShowImage("Lena Image", src);
    cvWaitKey(0);
    cvReleaseImage(src);
    cvReleaseImage(tmp);
    cvReleaseImage(result);

}