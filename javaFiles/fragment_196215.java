// Convert the blue colored image to binary (again), and we will have a good rectangular shape to detect
cv::Mat gray;
cv::cvtColor(blue, gray, cv::COLOR_BGR2GRAY);
cv::threshold(gray, binary, 225, 255, cv::THRESH_BINARY_INV);
cv::imshow("binary2", binary);
//cv::imwrite("binary2.png", binary);