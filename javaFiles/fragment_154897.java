if(imagesForTraining[j] == null)continue;//or do something, try to load again 
int width = imagesForTraining[j].width();   

int height = imagesForTraining[j].height();

grayImage[j] = IplImage.create(width, height, IPL_DEPTH_8U, 1);