for(int j = 0; j < numbers.length; j++)
{
    if(numbers[j] > max)
        max = numbers[j];
}

min = max;
for(int j = 0; j < numbers.length; j++)
{
    if(numbers[j] < min)
        min = numbers[j];
}