public static void main(String[] args){
    try{
        //Validation whether a file name is passed to the function
        if(args.length == 0){
            System.out.println("here...");
            log.error("No file was passed to the function");
            throw new IOException();
        }

        //Read the image from the input
        Mat inputMat = Highgui.imread(args[0],Highgui.CV_LOAD_IMAGE_GRAYSCALE);

        //Create a feature detector. In this case we are using SURF (Speeded-Up Robust Features) detector. 
        MatOfKeyPoint objectKeyPoints = new MatOfKeyPoint();
        FeatureDetector featureDetector = FeatureDetector.create(FeatureDetector.SURF);

        //A temporary file is created to input Hessian Threshold to the SURF detector
        File tempFile = File.createTempFile("config", ".yml");
        String settings = "%YAML:1.0\nhessianThreshold: 7000.\noctaves: 3\noctaveLayers: 4\nupright: 0\n";
        FileWriter writer = new FileWriter(tempFile, false);
        writer.write(settings);
        writer.close();

        //Read the configuration from the temporary file to assign the threshold for the detector
        featureDetector.read(tempFile.getPath());

        //Detect the features in the image provided
        featureDetector.detect(inputMat, objectKeyPoints);

        //Iterate through the list of key points detected in the previous step and find the Key Point with the largest size
        List<KeyPoint> objectKeyPointList = objectKeyPoints.toList();
        KeyPoint impKeyPoint = new KeyPoint();

        for(int i=0; i<objectKeyPointList.size(); i++){
            if(impKeyPoint == null){
                impKeyPoint = objectKeyPointList.get(i);
            }
            else if(impKeyPoint.size < objectKeyPointList.get(i).size){
                impKeyPoint = objectKeyPointList.get(i);
            }
        }

        //If the size of the Key Point is greater than 120 then reduce the size to 120 and if the size is less than 120 then increase to 120 
        if(impKeyPoint.size > 120){
            KeyPoint tempKeyPoint = new KeyPoint();
            tempKeyPoint = impKeyPoint;
            tempKeyPoint.size = 120;
            impKeyPoint = tempKeyPoint;
        }
        else if(impKeyPoint.size < 120){
            KeyPoint tempKeyPoint = new KeyPoint();
            tempKeyPoint = impKeyPoint;
            tempKeyPoint.size = 120;
            impKeyPoint = tempKeyPoint;
        }

        //Convert the Key Point to MatOfKeyPoint since drawKeyPoints accepts only MatOfKeyPoint
        MatOfKeyPoint impMatOfKeyPoint = new MatOfKeyPoint(impKeyPoint);

        //Mat for drawing the circle in the image
        Mat outputImage = new Mat(inputMat.rows(), inputMat.cols(), Highgui.CV_LOAD_IMAGE_COLOR);

        //Green color for the circle
        Scalar greenCircle = new Scalar(0, 255, 0);

        //Draw the circle around the optic nerve when detected
        Features2d.drawKeypoints(inputMat, impMatOfKeyPoint, outputImage, greenCircle, Features2d.DRAW_RICH_KEYPOINTS);

        //Write the image to a file
        Highgui.imwrite("surf_keypoints.png", outputImage);
    }catch(Exception e){
        log.fatal(e.getMessage());
    }

}