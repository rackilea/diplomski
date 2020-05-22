int rampFrames = 64;

for (int i = 0; i < rampFrames; i++)
{
     wave[i] *= i/(float)rampFrames;
}