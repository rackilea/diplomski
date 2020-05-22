// Crop the rectangular shape
if (squares.size() == 1)
{    
    cv::Rect box = cv::boundingRect(cv::Mat(squares[0]));
    std::cout << "* The location of the box is x:" << box.x << " y:" << box.y << " " << box.width << "x" << box.height << std::endl;

    // Crop the original image to the defined ROI
    cv::Mat crop = input(box);
    cv::imshow("crop", crop);
    //cv::imwrite("cropped.tiff", crop);
}
else
{
    std::cout << "* Abort! More than one rectangle was found." << std::endl;
}

// Wait until user presses key
cv::waitKey(0);

return 0;
}