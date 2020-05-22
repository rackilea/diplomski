//Binarization using fixed threshold -> failed because of shading background
threshold(source,otsu, 0, max_value, THRESH_OTSU);
//Adaptive threshold
adaptiveThreshold(source, adaptive, 255, ADAPTIVE_THRESH_MEAN_C,CV_THRESH_BINARY, 25, 11);

//Segmentation with Black-Hat to uniform background
int const morph_size = 20;
Mat element = getStructuringElement(CV_SHAPE_ELLIPSE, Size(2 * morph_size + 1, 2 * morph_size + 1), Point(morph_size, morph_size));
morphologyEx(source, morph, MORPH_BLACKHAT, element);
threshold(morph, destination, 16, 255, THRESH_BINARY_INV);