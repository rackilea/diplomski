try{
     int kernelSize = 3; // Change
     System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
     Mat source = Imgcodecs.imread("grayScale2.jpg",  Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
     Mat destination = new Mat(source.rows(),source.cols(),source.type());  
     Mat kernel = new Mat(kernelSize,kernelSize, CvType.CV_32F){
        {
           put(0,0,-1);
           put(0,1,0);
           put(0,2,1);

           put(1,0-2);          
           put(1,1,0);
           put(1,2,2);

           put(2,0,-1);
           put(2,1,0);
           put(2,2,1); // Leave it this way - don't uncomment
        }
     };       

     Imgproc.filter2D(source, destination, -1, kernel);
     Imgcodecs.imwrite("robinsonMaskExample.jpg", destination);

  } catch (Exception e) {
     System.out.println("Error: " + e.getMessage());
  }