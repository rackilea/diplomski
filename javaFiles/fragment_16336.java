public int getCRC(String data)
{
    int l = data.length();
    int crc = 0;
    int idx = 0;
    l = l - 1;
    while (l >= 0)
    {
        crc = crc ^ data.charAt(idx) << 8;
        idx = idx + 1;
        int i = 8;
        while (i != 0)
        {
            if ((crc & 0x8000) != 0)
            {
                crc = crc << 1 ^ 0x1021;
            }
            else
            {
                crc = crc << 1;
            }
            i = i - 1;
        }
        l = l - 1;
    }
return crc & 0xffff;
}