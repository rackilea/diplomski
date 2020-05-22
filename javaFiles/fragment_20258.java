// Darken red value by 50%
int color = ...; // some color input
int mask = 0xFF;

int a = (color >> 24) & mask;
int r = (color >> 16) & mask;
int g = (color >> 8) & mask;
int b = color & mask;

// convert to decimal form:
float rDecimal = r / 255f; 
  // Let r: 0x66 = 102 => rDecimal: 0.4

// darken with 50%, basically divide it by two
rDecimal = r/2; 
  // rDecimal: 0.2

// Go back to original representation and put it back to r
r = (int)(rDecimal * 255); 
  // r: 51 = 0x33

// Put it all back in place
color = (a << 24) + (r << 16) + (g << 8) + b;