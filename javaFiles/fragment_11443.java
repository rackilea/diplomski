final const int RED = 0;
final const int GREEN = 1;
final const int BLUE = 2;

int[][][] colorImage = new int[numRows][numColumns][3];
//...

int x = getSomeX();
int y = getSomeY();

int redComponent = colorImage[x][y][RED];
int greenComponent = colorImage[x][y][GREEN];
int blueComponent = colorImage[x][y][BLUE];