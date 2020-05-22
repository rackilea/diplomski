Mat src = imread("your image"); int row = src.rows; int col = src.cols;
    //Create contour
vector<vector<Point> > contours; 
vector<Vec4i> hierarchy;
Mat src_copy = src.clone();
    findContours( src_copy, contours, hierarchy, RETR_TREE, CHAIN_APPROX_SIMPLE);

// Create Mask
Mat_<uchar> mask(row,col);    
for (int j=0; j<row; j++)
    for (int i=0; i<col; i++)
        {
            if ( pointPolygonTest( contours[0], Point2f(i,j),false) =0)
            {mask(j,i)=255;}
            else
            {mask(j,i)=0;}
        };