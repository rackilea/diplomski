public static final int toInt(byte[] b) 
{
    int l = 0;
    l |= b[0] & 0xFF;
    l <<= 8;
    l |= b[1] & 0xFF;
    l <<= 8;
    l |= b[2] & 0xFF;
    l <<= 8;
    l |= b[3] & 0xFF;
    return l;
}

byte[] bytes = new byte[] {99, 4, 9, 0};
int i = toInt(bytes, 0);