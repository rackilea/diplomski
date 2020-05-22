public static boolean isUnique(int [] arry, int filled, int a)
{
  // filled should always be <=arry.length, but we can check both just to be safe
  for (int i = 0; i < arry.length && i<filled)
  {
    if (arry [i] == a)
    {
      return false; //not unique
    }
  }
  return true; // we made it through without finding a dup, must be unique
}