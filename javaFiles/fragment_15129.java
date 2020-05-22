double x = 24.801044;
double y = 120.993085;
System.out.println("Input: "+x+"; "+y);
// Encode
long data = (Math.round(x * 1e6) << 32) | Math.round(y * 1e6);
// Now send the data to another phone
// Decode
double resX = (data >>> 32)/1e6;
double resY = ((int)data)/1e6;
System.out.println("Input: "+resX+"; "+resY);