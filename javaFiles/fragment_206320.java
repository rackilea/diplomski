Color c = jColorChooser1.getColor();
float[] comp = new float[3];
Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), comp);
comp[0]*= 360;
comp[1]*= 100;
comp[2]*= 100;
return  comp[0]+", "+comp[1]+", "+comp[2];