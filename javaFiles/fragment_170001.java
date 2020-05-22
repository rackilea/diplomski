Mat img = Highgui.imread(argv[1], Highgui.CV_LOAD_IMAGE_GRAYSCALE);
int erosion_size = 5;
Mat element  = Imgproc.getStructuringElement(
    Imgproc.MORPH_CROSS, new Size(2 * erosion_size + 1, 2 * erosion_size + 1), 
    new Point(erosion_size, erosion_size)
);
Imgproc.erode(img, img, element);