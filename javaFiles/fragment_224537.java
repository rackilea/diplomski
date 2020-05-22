int x1 = (width - 1)/2;
int x2 = width/2;
int y1 = (height - 1)/2;
int y2 = height/2;
double median = (mat[width*y1 + x1] + mat[width*y1 + x2] +
                 mat[width*y2 + x1] + mat[width*y2 + x2])*0.25;