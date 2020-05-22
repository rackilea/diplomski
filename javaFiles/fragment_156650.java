float x = 1.0000001;
float y = 1.1000000001;
x = fixDec(x, 2);
y = fixDec(y, 2);
float a = x + y;
round(a);