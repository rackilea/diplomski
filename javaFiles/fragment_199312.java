Mat mat = new Mat(h,w, CvType.CV_8U);

    mat.put(0, 0, array);

    //Imshow is = new Imshow("try");for verification

    MatOfPoint2f quad = new MatOfPoint2f(p);//array of corner points

    MatOfPoint2f rect = new MatOfPoint2f(farray);//final array of corner points into which mat should be warped into

    Mat transmtx = Imgproc.getPerspectiveTransform(quad,rect);

    Mat output = new Mat(w,h,CvType.CV_8U); 

    Imgproc.warpPerspective(mat, output, transmtx, new Size(w,h),Imgproc.INTER_CUBIC);

    //is.showImage(output);     

    MatOfByte matOfByte = new MatOfByte();

    Highgui.imencode(".jpg", output, matOfByte); 

    byte[] byteArray = matOfByte.toArray();

    File f = new File("retrieve1.jpg");

    BufferedImage img1 =null;

    InputStream in = new ByteArrayInputStream(byteArray);

    img1  = ImageIO.read(in);

    WritableRaster raster = (WritableRaster)img1.getData();

    raster.setDataElements(0,0,byteArray);

    img1.setData(raster);