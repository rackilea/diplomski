//high precision calculations with doubles
double hx = bb.width / 2d;
double hy = bb.height / 2d;

//less precise int values
int newWidth = (int)hx;  //use brackets to type cast from double to int
int newHeight = (int)hy; 
Rectangle half = new Rectangle(bb.x, bb.y, newWidth, newHeight);