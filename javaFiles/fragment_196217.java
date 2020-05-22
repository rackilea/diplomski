// Ok, let's go ahead and try to detect all rectangular shapes
std::vector<std::vector<cv::Point> > squares;
findSquares(binary, squares);
std::cout << "* Rectangular shapes found: "  << squares.size() << std::endl;

// Draw all rectangular shapes found
cv::Mat output = input.clone();
drawSquares(output, squares);
//cv::imwrite("output.png", output);