public class NumberShifter
{

public int[] go(int[] arrayToBeShifted, int index)
{
  for (int i = 0, e = 0; i < arrayToBeShifted.length; i++) 
  {
    if (arrayToBeShifted[i] == 7)
    {
    arrayToBeShifted[i] = arrayToBeShifted[e];
    arrayToBeShifted[e] = 7;
    e++;
    }
  }
  return arrayToBeShifted;
}
}