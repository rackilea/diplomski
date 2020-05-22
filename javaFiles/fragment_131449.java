public static boolean isUnique(int [] arry, int a)
{
  for (int i = 0; i < arry.length)
  {
    if (arry [i] == a)
    {
      return false; //not unique
    }
  }
  return true; // we made it through without finding a dup, must be unique
}