Random rng = new Random(0);
double[] lognormalValues = new double[1000];

for (int i = 0; i < 1000; ++i)
{
    stdNormal   = rng.nextGaussian();
    normalValue = stddev*stdNormal + mean;

    logNormalValues[i] = Math.exp(normalValue);
}