for (int i = array.length - 1; i > midpoint; i--)
{
    array[i] = array[i-1];
}

array[midpoint] = somenumber