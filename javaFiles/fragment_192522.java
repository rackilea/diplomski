public class MyMat
{
    private Mat i;

    public MyMat(Mat i) {
       this.i = i;
    }

    public Mat getBackingMat() {
       return this.i;
    }

    public MyMat cannyEdges(int low, int high)
    {      
        // ...
        return new MyMat(I); // lets you chain operations
    }

    public MyMat cannyEdges()
    {
        return new MyMat(ImageProcessing.cannyEdges(I, ContourDetection.CANNY_LOWTHRES, ContourDetection.CANNY_HIGHTHRES));
    }

    public MyMat getHoughLines(...some_conf_vars...)
    {
        // ...
    }
}

MyMat myMat = new MyMat(I);
lines = myMat.cannyEdges(20, 100).calcHoughLines();