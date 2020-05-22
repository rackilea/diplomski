// assume that origin image has 3 channels
cv::Scalar myColor(255,0,255);  

// create dst with background color of your choice
cv::Mat dst(src.size(),src.type(),myColor);

// now copy
src.copyTo(dst, mask);