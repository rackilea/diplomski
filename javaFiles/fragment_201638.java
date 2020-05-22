extern "C"
JNIEXPORT jobject JNICALL
Java_prisca_ctest_OpenCvCamera_doWithMat(JNIEnv *env, jobject instance,
        jlong matAddrGr, jlong matAddrRgba) {

    Mat &image = *(Mat *) matAddrRgba;
    Rect bounding_rect;

    Mat thr(image.rows, image.cols, CV_8UC1);
    cvtColor(image, thr, CV_BGR2GRAY); // Convert to gray
    threshold(thr, thr, 150, 255, THRESH_BINARY + THRESH_OTSU); //Threshold the gray

    vector<vector<Point> > contours; // Vector for storing contour
    vector<Vec4i> hierarchy;
    findContours(thr, contours, hierarchy, CV_RETR_CCOMP,
        CV_CHAIN_APPROX_SIMPLE); // Find the contours in the image
    sort(contours.begin(), contours.end(),
        compareContourAreas);    // Store the index of largest contour
    bounding_rect = boundingRect((const _InputArray &) contours[0]);

    rectangle(image, bounding_rect, Scalar(250, 250, 250) , 5);

    jclass rectClass = env->FindClass("org/opencv/core/Rect");
    jmethodID rectCtorID = env->GetMethodID(rectClass, "<init>", "(IIII)V");
    return env->NewObject(rectClass, rectCtorID, bounding_rect.x, bounding_rect.y, bounding_rect.width, bounding_rect.height);
}