int sampleArray[] = new int[numSamples];

for(int i = 0, j=0;i < bytearray.length;)
{
    int iLow = bytearray[i];
    i++;
    int iHigh = bytearray[i];
    i++;

    sampleArray[j] = getSixteenBitSample(iHigh, iLow);
    j++;
}