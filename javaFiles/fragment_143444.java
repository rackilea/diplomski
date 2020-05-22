// Just building an array with double values
int size = 10;
double measurements[] = new double[size];

for (int i = 0; i < measurements.length; i++)
{
    measurements[i] = i;
}

// Using the Apache functions
double myAverage = StatUtils.mean (measurements);
double myMax = StatUtils.max (measurements);