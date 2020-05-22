int width = image.getWidth();

...

byte R = a[3*(x+y*width)];
byte G = a[1+3*(x+y*width)];
byte B = a[2+3*(x+y*width)];