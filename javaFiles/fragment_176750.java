//uchar* ptr2imgData = dynamic_cast<uchar *>( imgPtr );
//cv::Mat img( cv::Size{ WIDTH, HEIGHT }, CV_8UC3, ptr2imgData ); // C++

uchar* ptr2imgData = (uchar *)imgPtr;  // uchar is unsigned char
CvMat* img = cvCreateMat( WIDTH, HEIGHT, CV_8UC3 );
img->ptr = imgPtr;