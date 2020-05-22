public static int getPositionInBase64(int n)
{
    for (int p = 0; p < base64Order.length; p++)
    {
        if (n == base64Order[p])
        {
            return p;
        }
    }
    return -1;
}