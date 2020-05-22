final double[] mOdds = {0.10, 0.25, 0.30, 0.35};   
// note, mOdds totals 1.0

public int pickSprite()
{
    double rand = Math.Random();
    for(int i=0;i<mOdds.length;i++)
    {
        if(rand < mOdds[i])
            return i;
        rand -= mOdds[i];
    }
    return -1;                    // should never reach this
}