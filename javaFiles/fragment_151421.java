int red = interpolate((int) x, y, p1red, p2red, p3red);
int green = interpolate((int) x, y, p1green, p2green, p3green);
int blue = interpolate((int) x, y, p1blue, p2blue, p3blue);

//System.out.println("xyrgb: " + (int)x + ", " + y + ", " + red + ", " + green + ", " + blue);

bI.setRGB((int)x, y, new Color(red, green, blue).getRGB());