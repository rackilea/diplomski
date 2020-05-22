CvMoments moments = new CvMoments();

        cvMoments(imgThreshold, moments, 1);

        double moment10 = cvGetSpatialMoment(moments, 1, 0);
        double moment01 = cvGetSpatialMoment(moments,0,1);
        double area = cvGetCentralMoment(moments, 0, 0);

         int posX = 0;
         int posY = 0;

        int lastX = posX;
        int lastY = posY;

        posX = (int) (moment10/area);
        posY = (int) (moment01/area);

        cvCircle(iplRgbImage, new CvPoint(posX,posY), 3, CvScalar.GREEN, -1, 8, 0);