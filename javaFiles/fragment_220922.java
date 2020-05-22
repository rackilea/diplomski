// set top left position and dimensions of extracted area
int topLeftX = ...;
int topLeftY = ...;
int width = ...;
int height = ...;

// create Rect object for extracted area
Rect extractedRect = new Rect (topLeftX, topLeftY, width, height);

// create Mat from sourceMat
Mat extractedMat = new Mat(sourceMat, extractedRect);