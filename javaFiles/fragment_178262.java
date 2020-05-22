IplImage gray = cvCreateImage(cvGetSize(markers), IPL_DEPTH_8U, 1); 
cvCvtColor(markers, gray, CV_BGR2GRAY);

IplImage img32bit1chan = cvCreateImage(cvGetSize(gray), IPL_DEPTH_32S, 1);

// convert 8-bit 1-channel image to 32-bit 1-channel
cvConvertScale(gray, img32bit1chan , 1/255.);

cvWatershed(image, img32bit1chan);