public static void main(String[] args) 
{
    CvCapture capture = cvCreateCameraCapture(0);
    if (capture == null)
    {
        System.out.println("!!! Failed cvCreateCameraCapture");
        return;
    }

    cvNamedWindow("camera_demo");

    IplImage grabbed_image = null;

    while (true)
    {
        grabbed_image = cvQueryFrame(capture);
        if (grabbed_image == null)
        {
            System.out.println("!!! Failed cvQueryFrame");
            break;
        }                    

        cvShowImage("camera_demo", grabbed_image);
        int key = cvWaitKey(33);
        if (key == 27)
        {
            break;
        }
    }

    cvReleaseCapture(capture);
}