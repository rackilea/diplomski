//Calculate translation of the central point of triangle to the origin.
float xTranslation = 0 - centralPointX;
float yTranslation = 0 - centralPointY;

//Translate all points by the translation calculated.
float translatedX1 = tempX1 + xTranslation;
float translatedY1 = tempY1 + yTranslation;
float translatedX2 = tempX2 + xTranslation;
float translatedY2 = tempY2 + yTranslation;
float translatedX3 = tempX3 + xTranslation;
float translatedY3 = tempY3 + yTranslation;