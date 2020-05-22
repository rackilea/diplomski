Imgproc.cvtColor(image, image, Imgproc.COLOR_BGR2GRAY, 0);
    originalFrameGrayScale = image.clone();

    Mat morph = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(9, 3));
    Imgproc.morphologyEx(image, image, Imgproc.MORPH_TOPHAT, morph);
    Imgproc.Sobel(image, image, -1, 2, 0);
    Imgproc.GaussianBlur(image, image, new Size(5,5), 3,3);
    Imgproc.morphologyEx(image, image, Imgproc.MORPH_CLOSE, morph);
    Imgproc.threshold(image, image, 200, 255, Imgproc.THRESH_OTSU);
    Vector<Rect> rectangles = detectionContour(image);