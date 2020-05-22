double d = distance(currentPixel, focusPoint); //I'll leave the implementation for you
double factor = Math.max(1.0, d/extent);

int red = (int) (firstCol.getRed() * factor + secondCol.getRed() * (1.0 - factor) );
int green= (int) firstCol.getGreen() * factor + secondCol.getGreen()* (1.0 - factor) );
int blue = (int) (firstCol.getBlue() * factor + secondCol.getBlue()* (1.0 - factor) );