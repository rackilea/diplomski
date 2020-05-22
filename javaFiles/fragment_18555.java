int max = Integer.MIN_VALUE;
int min = Integer.MAX_VALUE;
int sum = 0;
for(int i=0; i<array.length; i++)
{
    if(array[i] < min)
       min = array[i];
    if(array[i] > max)
       max = array[i];
    sum += array[i];
}

return (max - min + 1)(max + min)/2 - sum;