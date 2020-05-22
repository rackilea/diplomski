int current = 1;
for (int i = 0; i < 10001; i++)
{
    current++;
    while (!isPrime(current))
    {
        current++;
    }
}