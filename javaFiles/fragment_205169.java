public static int[] range(int[] a, int low, int high) 
{
  int[] rangeArray = new int[a.length];//this is the most we will need
  int numbersFound = 0;//to keep track of result array index    

  for (int idx = 0; idx < a.length; idx++) {
  {  
     if (a[idx] >= low && a[idx] <= high)
     {
        rangeArray[numbersFound++] = a[i];
     }
  }

  return rangeArray;
}