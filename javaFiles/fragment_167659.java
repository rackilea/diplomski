Color
{
...
    public void getRGBBytes(byte[] dest, int offset)
    {
        dest[offset++] = redValue;
        dest[offset++] = greenValue;
        dest[offset] = blueValue;
    }
}