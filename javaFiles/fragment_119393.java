Mat im = imread("aRh8C.png", 0);
// apply Otsu threshold
Mat bw;
threshold(im, bw, 0, 255, CV_THRESH_BINARY_INV | CV_THRESH_OTSU);
// take the distance transform
Mat dist;
distanceTransform(bw, dist, CV_DIST_L2, CV_DIST_MASK_PRECISE);
Mat dibw;
// threshold the distance transformed image
double SWTHRESH = 8;    // stroke width threshold
threshold(dist, dibw, SWTHRESH/2, 255, CV_THRESH_BINARY);
Mat kernel = getStructuringElement(MORPH_RECT, Size(3, 3));
// perform opening, in case digits are still connected
Mat morph;
morphologyEx(dibw, morph, CV_MOP_OPEN, kernel);
dibw.convertTo(dibw, CV_8U);
// find contours and filter
Mat cont;
morph.convertTo(cont, CV_8U);

Mat binary;
cvtColor(dibw, binary, CV_GRAY2BGR);

const double HTHRESH = im.rows * .5;    // height threshold
vector<vector<Point>> contours;
vector<Vec4i> hierarchy;
vector<Point> digits; // points corresponding to digit contours

findContours(cont, contours, hierarchy, CV_RETR_CCOMP, CV_CHAIN_APPROX_SIMPLE, Point(0, 0));
for(int idx = 0; idx >= 0; idx = hierarchy[idx][0])
{
    Rect rect = boundingRect(contours[idx]);
    if (rect.height > HTHRESH)
    {
        // append the points of this contour to digit points
        digits.insert(digits.end(), contours[idx].begin(), contours[idx].end());

        rectangle(binary, 
            Point(rect.x, rect.y), Point(rect.x + rect.width - 1, rect.y + rect.height - 1),
            Scalar(0, 0, 255), 1);
    }
}

// take the convexhull of the digit contours
vector<Point> digitsHull;
convexHull(digits, digitsHull);
// prepare a mask
vector<vector<Point>> digitsRegion;
digitsRegion.push_back(digitsHull);
Mat digitsMask = Mat::zeros(im.rows, im.cols, CV_8U);
drawContours(digitsMask, digitsRegion, 0, Scalar(255, 255, 255), -1);
// expand the mask to include any information we lost in earlier morphological opening
morphologyEx(digitsMask, digitsMask, CV_MOP_DILATE, kernel);
// copy the region to get a cleaned image
Mat cleaned = Mat::zeros(im.rows, im.cols, CV_8U);
dibw.copyTo(cleaned, digitsMask);