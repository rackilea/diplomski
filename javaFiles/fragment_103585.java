string filename = "captcha.jpg";
Mat src = imread(filename);
Mat gray;
cvtColor(src, gray, CV_BGR2GRAY);
Mat thres;
threshold(gray, thres, 200, 255, 0);

vector<vector<Point>> contours;
vector<Vec4i> hierarchy;

findContours(thres.clone(), contours, hierarchy, CV_RETR_TREE, CV_CHAIN_APPROX_SIMPLE);

Mat firstImage = src.clone();
for(int i=0; i< contours.sizes(); i++)
{
    Rect r = boundingRect(contours[i]);
    rectangle(firstImage, r, CV_RGB(255, 0, 0), 2);
}

imwrite("result.png", firstImage);