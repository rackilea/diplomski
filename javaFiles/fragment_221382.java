public static double FindTheRoot(double previousG, int number)
{
    double errorMargin = 0.00001;
    double nextGuess = (previousG + number / previousG) / 2;
    double error = nextGuess * nextGuess - number;

    if (error < errorMargin)
        return nextGuess;
    else
        // ...