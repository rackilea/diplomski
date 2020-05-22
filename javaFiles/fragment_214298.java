public boolean containsZero(int[] array, int i)
{  
  if (i < array.length)
  {
     if (array[i] == 0)
        return true;
     else
        return containsZero(array, i+1);     
  }
  return false;
}