private int scoreCalc(int [] results)
{
  int score=0;
  for(int i = 0; i < 7; i++)
  {
    int repeated=0;
    for(int j = 0; j < results.length; j++)
    {
      if(results[j] == i)
      {
        repeated++;
      }
    }
    score += countPoints(repeated);
  }
}
private int countPoints(int repetitions){
//here goes the scoring system
}