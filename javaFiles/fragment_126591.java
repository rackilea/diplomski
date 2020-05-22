int targetWidth = 1024;
int targetHeight = 768;
int myWidth = 800;
int myHeight = 600;

double scaleX = targetWidth/myWidth;
double scaleY = targetHeight/myHeight;

double targetMouseX = myMouseX * scaleX; // 
double targetMouseY = myMouseY * scaleY; //