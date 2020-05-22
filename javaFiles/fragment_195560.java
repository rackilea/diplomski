public int getMax(int[] arr)
{
  int max = arr[0];  //To have a baseline
  for(int i = 1; i < arr.length; i++)
  {
    if(arr[i] > max)
    {
      max = arr[i];
    }
  }
  return max;
}

public int getMin(int[] arr)
{
  int min = arr[0];  //To have a baseline
  for(int i = 1; i < arr.length; i++)
  {
    if(arr[i] < min)
    {
      min = arr[i];
    }
  }
  return min;
}