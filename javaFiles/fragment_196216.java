// Erode & Dilate to isolate segments connected to nearby areas
int erosion_type = cv::MORPH_RECT; 
int erosion_size = 5;
cv::Mat element = cv::getStructuringElement(erosion_type, 
                                            cv::Size(2 * erosion_size + 1, 2 * erosion_size + 1), 
                                            cv::Point(erosion_size, erosion_size));
cv::erode(binary, binary, element);
cv::dilate(binary, binary, element);
cv::imshow("Morphologic Op", binary); 
//cv::imwrite("morpho.png", binary);