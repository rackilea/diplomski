short curSample = getShort(buffer[i*2], buffer[i*2+1]);
int temp = curSample * rGain;
if (temp>=32767)
    curSample=32767;
else if (temp<=-32768)
    curSample=-32768;
else
    curSample=(short)temp;