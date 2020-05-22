for(int i = 0; i < b.length/2; i++)
{
    byte temp = b[i];
    b[i] = b[b.length - i - 1];
    b[b.length - i - 1] = temp;
}