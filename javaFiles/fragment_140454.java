int sum = 0;
for(int i=1; i<10000; i++)
{
    if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
        sum += i;
}