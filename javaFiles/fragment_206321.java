private String getColorString(Color color)
{
    float[] comp = new float[3];
    Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), comp);
    comp[0]*= 360;
    comp[1]*= 100;
    comp[2]*= 100;
    return  comp[0]+", "+comp[1]+", "+comp[2];
}