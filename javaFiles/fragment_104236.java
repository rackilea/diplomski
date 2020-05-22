for (a = 0; a <= 255; a++)
{
    int index = a % intLength;
    sTemp = inputString.substring( index, index + 1 );
    ctmp = sTemp.toCharArray()[0];
    sbox[a] = (int)ctmp;
}