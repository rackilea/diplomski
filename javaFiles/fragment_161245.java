public int someMethodName(int value)
{
  int splittingValue = 100;

  if(value > splittingValue)
  {
    return splittingValue * 5 + (value - splittingValue) * 2;
  }
  else {
    return value * 5;
  }
}