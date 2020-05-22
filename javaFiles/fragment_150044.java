int mid = array.length/2;

for (int i = mid; i < array.length-1; i++)
{
    int temp = array[i];
    array[i] = array[i+1];
    array[i+1] = temp;
}