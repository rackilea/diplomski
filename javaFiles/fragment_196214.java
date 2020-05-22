// Find the contours in the thresholded image
std::vector<std::vector<cv::Point> > contours;
cv::findContours(binary, contours, cv::RETR_LIST, cv::CHAIN_APPROX_SIMPLE);

// Fill the areas of the contours with BLUE (hoping to erase everything inside a rectangular shape)
cv::Mat blue = input.clone();      
for (size_t i = 0; i < contours.size(); i++)
{
    std::vector<cv::Point> cnt = contours[i];
    double area = cv::contourArea(cv::Mat(cnt));               

    //std::cout << "* Area: " << area << std::endl; 
    cv::drawContours(blue, contours, i, cv::Scalar(255, 0, 0), 
                     CV_FILLED, 8, std::vector<cv::Vec4i>(), 0, cv::Point() );         
}       

cv::imshow("Countours Filled", blue);  
//cv::imwrite("contours.png", blue);