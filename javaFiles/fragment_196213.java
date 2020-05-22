int main(int argc, char* argv[])
{
// Load input image (colored, 3-channel)
cv::Mat input = cv::imread(argv[1]);
if (input.empty())
{
    std::cout << "!!! failed imread()" << std::endl;
    return -1;
}   

// Convert input image to grayscale (1-channel)
cv::Mat grayscale = input.clone();
cv::cvtColor(input, grayscale, cv::COLOR_BGR2GRAY);
//cv::imwrite("gray.png", grayscale);