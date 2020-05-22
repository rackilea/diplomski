public boolean isThreeKind( int rankHist[]) 
{
  for (int i=0;i<=13;i++)
  {
      if (rankHist[i]<3)
      {
          return false; // Will return false if either of the element have value <3
      }
  }
  return true;  // Will return true only if all the 13 elements have value >=3
}